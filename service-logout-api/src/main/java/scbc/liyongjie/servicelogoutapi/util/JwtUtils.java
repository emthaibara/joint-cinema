package scbc.liyongjie.servicelogoutapi.util;


import com.auth0.jwt.JWT;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/9
 */

public class JwtUtils {

    private static final String NUMBER = "number";

    public static String getClime(String token){
        return JWT.decode(token).getClaim(NUMBER).asString();
    }

}
