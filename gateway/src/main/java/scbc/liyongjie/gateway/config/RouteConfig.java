package scbc.liyongjie.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import scbc.liyongjie.gateway.filter.TokenFilter;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/9
 */

@Configuration
public class RouteConfig {

    @Resource
    private TokenFilter tokenFilter;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("service-logout-provider",
                        predicateSpec -> predicateSpec.path("/logout")
                        .uri("lb://service-logout-provider"))
                .route("service-upload-isSecondPass-route",
                        predicateSpec -> predicateSpec.path("/isSecondPass")
                        .uri("lb://service-upload-provider"))
                .route("service-upload-chunk-route",
                        predicateSpec -> predicateSpec.path("/chunk")
                        .uri("lb://service-upload-provider"))
                .route("service-upload-mergeChunk-route",
                        predicateSpec -> predicateSpec.path("/mergeChunk")
                        .uri("lb://service-upload-provider"))
                .build();
    }

}
