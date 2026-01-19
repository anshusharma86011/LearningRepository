package com.product.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Component
public class JwtUtil
{

    private static String secretKey;

    JwtUtil()
    {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32];
        random.nextBytes(key);
        secretKey =Base64.getEncoder().encodeToString(key);



    }

    public String generateToken(String username, List<String> roles)
    {
        return Jwts.builder().setSubject(username)
                .claim("roles",roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*2))
                .signWith(getSignedKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignedKey()
    {
        byte [] keyBytes = Decoders.BASE64.decode(secretKey);
         return Keys.hmacShaKeyFor(keyBytes);
     }

     public Boolean validToken( String token , String username)
     {
      return (extractusername(token).equals(username)&& !isTokenExpired(token));
     }
     public String extractusername(String token)
     {

       return extractClaim(token, Claims::getSubject);

     }
    public Date extractExpiratioin(String token)
    {
        return extractClaim(token,Claims::getExpiration);
    }
    public Boolean isTokenExpired(String token)
    {
        return   extractExpiratioin(token).before(new Date());

    }
    public  List<String> extractRole(String token)
    {
        return  extractClaim(token,claims -> claims.get("roles",List.class));
    }



    public <T> T extractClaim(String token, Function<Claims,T> claimResolver)
    {
           final Claims claims=     Jwts.parserBuilder()
                        .setSigningKey(getSignedKey()).
                        build().parseClaimsJws(token).
                        getBody();
                       return claimResolver.apply(claims);

    }



}
