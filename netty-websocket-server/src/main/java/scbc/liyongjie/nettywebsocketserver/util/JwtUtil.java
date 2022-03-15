package scbc.liyongjie.nettywebsocketserver.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scbc.liyongjie.nettywebsocketserver.enums.TokenClaimEnum;

import java.util.Date;

import static com.auth0.jwt.impl.PublicClaims.ISSUER;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 */

public class JwtUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

    private static final String SALT = "1a2b3c4d";

    public static Boolean verify(String token){
        try {
            JWT.require(Algorithm.HMAC256(SALT))
                    .withIssuer(ISSUER)
                    .build().verify(token);
        }catch (JWTVerificationException e){
            log.error(e.getMessage());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private static final long EXPIREDTIME = 1000000000*15L;

    public static String generateToken(String username,String id){
        //key 这里固定
        return JWT.create()
                .withIssuer(ISSUER)
                .withClaim(TokenClaimEnum.ID.getKey(), id)
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis()+EXPIREDTIME))
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(SALT));
    }

    public static String getClaim(TokenClaimEnum claimEnum, String token){
        return JWT
                .decode(token)
                .getClaim(claimEnum.getKey())
                .asString();
    }
}

