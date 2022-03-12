package scbc.liyongjie.servicessoapi.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scbc.liyongjie.servicessoapi.enums.PrefixEnum;
import scbc.liyongjie.servicessoapi.exception.BaseException;

import java.util.Date;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/6
 *      jwt生成工具
 */

public class JwtUtils {

    private static final Logger log = LoggerFactory.getLogger(JwtUtils.class);

    private static final String ISS = "scbc.liyongjie.service-sso-api";    //签发人
    private static final Long EXP = 1000*60*60*24*2L;    //48h / 两天
    private static final String SUB = "sso";    //主题

    public static String creatJwt(String number,String secret){
        try {
            return JWT.create()
                    .withIssuer(ISS)
                    .withExpiresAt(new Date(System.currentTimeMillis()+EXP))
                    .withIssuedAt(new Date())
                    .withClaim(PrefixEnum.NUMBER.getPrefix(),number)
                    .withSubject(SUB)
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException exception){
            log.error(exception.getMessage());
            throw new BaseException("服务器生成token异常！\n 异常信息为:"+exception.getMessage());
        }
    }

}
