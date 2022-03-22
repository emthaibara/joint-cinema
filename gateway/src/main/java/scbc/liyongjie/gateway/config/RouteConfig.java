package scbc.liyongjie.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/9
 */

@Configuration
public class RouteConfig {

    //todo 统一由gateway路由请求，对外暴露的端口只需要一个----8778,腾讯云服务器公网IP-----111.229.125.189
    //todo http://111.229.125.189:8778/Apixxx
    //todo 所有对外暴露的Api接口统一在gateway通过jwt token验证身份，限流等操作
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()

                //todo logoutApi     must carry   RequestParam--{}
                .route("service-logout-provider",
                        predicateSpec -> predicateSpec.path("/logout")
                                .uri("lb://service-logout-provider"))
                //todo 更改昵称Api     must carry   RequestParam--{}
                .route("service-nickname-provider",
                        predicateSpec -> predicateSpec.path("/logout")
                                .uri("lb://service-nickname-api-provider"))

                //todo 更改头像Api     must carry   RequestParam--{}
                .route("service-logout-provider",
                        predicateSpec -> predicateSpec.path("/set/nickname/")
                                .uri("lb://service-logout-provider"))

                //todo video相关Api    must carry RequestParam--{}
                .route("service-get-video-route",
                        predicateSpec -> predicateSpec.path("/get/video/")
                                .uri("lb://service-video-api-provider"))
                .route("service-get-share-video-route",
                        predicateSpec -> predicateSpec.path("/get/friend/share/videoList/")
                                .uri("lb://service-video-api-provider"))

                //todo friend和 get message cache相关Api     must carry  RequestParam--{}
                .route("service-get-offline-friend-route",
                        predicateSpec -> predicateSpec.path("/get/offline/friend/")
                                .uri("lb://service-netty-server-home-provider"))
                .route("service-get-online-friend-route",
                        predicateSpec -> predicateSpec.path("/get/online/friend/")
                                .uri("lb://service-netty-server-home-provider"))
                .route("service-get-friend-apply-cache-route",
                        predicateSpec -> predicateSpec.path("/get/friend/apply/cache/")
                                .uri("lb://service-netty-server-home-provider"))
                .route("service-get-online-friend-route",
                        predicateSpec -> predicateSpec.path("/get/online/friend/")
                                .uri("lb://service-netty-server-home-provider"))
                .route("service-get-video-share-launch-route",
                        predicateSpec -> predicateSpec.path("/get/video/share/launch/cache/")
                                .uri("lb://service-netty-server-home-provider"))
                //todo 放映室的协同操作相关Api     must carry   RequestParam--{}


                .build();
    }

}
