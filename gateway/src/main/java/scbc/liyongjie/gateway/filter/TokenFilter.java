package scbc.liyongjie.gateway.filter;

import com.alibaba.fastjson.JSON;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import scbc.liyongjie.gateway.enums.CodeMsgEnums;
import scbc.liyongjie.gateway.result.Result;
import scbc.liyongjie.gateway.util.JwtUtils;
import scbc.liyongjie.gateway.util.RedisUtils;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/9
 *         1.检查请求是否携带token
 *         2.检查token是否合法
 *         3.检查token是否过期
 */
@Component
public class TokenFilter implements GatewayFilter {

    private static final String TOKEN = "token";

    @Resource
    private RedisUtils redisUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String token = request.getHeaders().getFirst(TOKEN);

        if (ObjectUtils.isEmpty(token))
            return denyAccess(exchange,new Result<>().error(CodeMsgEnums.ILLEGAL));

        String secret = redisUtils.get(TOKEN+token);

        //确保redis缓存重的token信息未过期，过期则认为登录超时
        if (ObjectUtils.isEmpty(secret))
            return denyAccess(exchange,new Result<>().error(CodeMsgEnums.EXPIRED));

        return check(token,secret,exchange,chain);
    }

    /**
     * 拦截并返回自定义的json字符串
     */
    private Mono<Void> denyAccess(ServerWebExchange exchange, Result<?> result) {
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        byte[] bytes = JSON.toJSONBytes(result);
        DataBuffer buffer = response.bufferFactory().wrap(bytes);
        return response.writeWith(Mono.just(buffer));
    }

    private Mono<Void> check(String token,String secret,ServerWebExchange exchange , GatewayFilterChain chain){
        //验证token合法性以及是否过期
        switch (JwtUtils.checkJwt(token,secret)){
            case EXPIRED_ILLEGAL:
                return denyAccess(exchange,new Result<>().error(CodeMsgEnums.EXPIRED));
            case SECRET_ILLEGAL:
            case BASE_ILLEGAL:
                return denyAccess(exchange,new Result<>().error(CodeMsgEnums.ILLEGAL));
            case OK:
        }

        return chain.filter(exchange);
    }

}
