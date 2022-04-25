package scbc.liyongjie.gateway.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import scbc.liyongjie.gateway.enums.VerifyJwtEnums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/9
 */

public class JwtUtils {
    public static VerifyJwtEnums checkJwt(String jwt,String secret){
        try {
            JWT.require(Algorithm.HMAC256(secret)).build().verify(jwt);
        }catch (SignatureVerificationException e){
            return VerifyJwtEnums.SECRET_ILLEGAL;
        }catch (TokenExpiredException e){
            return VerifyJwtEnums.EXPIRED_ILLEGAL;
        }catch (JWTVerificationException ignored){
            return VerifyJwtEnums.BASE_ILLEGAL;
        }
        return VerifyJwtEnums.OK;
    }
}
