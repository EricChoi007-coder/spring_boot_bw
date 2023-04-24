package net.demoproject.venetian.utils;

import net.demoproject.venetian.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtils {

    /**
     * expire week
     */
    private  static final long EXPIRE = 60000 * 60 * 24 * 7;
    //private  static final long EXPIRE = 1;


    /**
     * secret key
     */
    private  static final String SECRET = "venetian.com";


    /**
     * token-prefix
     */
    private  static final String TOKEN_PREFIX = "venetian";


    /**
     * subject
     */
    private  static final String SUBJECT = "venetian";


    /**
     * generate token with user info
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){

        String token = Jwts.builder().setSubject(SUBJECT)
                //payload-info setting
                .claim("id",user.getId())
                .claim("name",user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();

        token = TOKEN_PREFIX + token;


        return token;
    }


    /**
     * validate token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){

        try{
            final  Claims claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }

    }
}
