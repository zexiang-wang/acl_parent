package com.atguigu.security.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenManager {
    // token 有效市场
    private long tokenEcpiration = 24*60*60*1000;
    // 编码密钥
    private String tokenSignKey = "123456";

    // 1 根据用户名生成token
    public String createToken(String username){
        String token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+tokenEcpiration))
                .signWith(SignatureAlgorithm.HS512,tokenSignKey).compressWith(CompressionCodecs.GZIP).compact();
        return token;
    }

    // 2 根据token字符串得到用户信息
    public String getUserInfoFromToken(String token){
        String userInfo = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
        return userInfo;
    }

    // 3 删除token
    public void removeToken(String token){

    }

}
