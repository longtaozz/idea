package com.zt.jinanzf.common.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TokenUtil {
	
    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expiration}")
    private Long expiration;
	
	/**
	 * 生成构成token的参数
	 * @param userCode
	 * @return
	 */
	public String generateToken(String username){
		return Jwts.builder()//创建token令牌
				.setSubject(username)//设置面向的主体用户
				.setIssuedAt(new Date())//签发生成时间
				.setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))//设置过期时间
				.signWith(SignatureAlgorithm.HS512, secret)//生成签名
				.compact();//生成token
	}
	
	/**
	 * 从token中获取用户帐号
	 * @param token
	 * @return
	 */
	public String getUsercodeFromToken(String token){
		String userCode = null;
			final Claims claims = Jwts.parser()//解析token的playload
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
			userCode = claims.getSubject();//获取设置的主体用户

		return userCode;
	}

	/**
	 * 获取token过期时间
	 * @param token
	 * @return
	 */
    public Date getExpirationDateFromToken(String token) {
        Date expiration = null;
        try {
            final Claims claims = Jwts.parser()
            		.setSigningKey(secret)
            		.parseClaimsJws(token)
            		.getBody();
            expiration = claims.getExpiration();
        } catch (Exception e) {
            log.error("getExpirationDateFromToken", e);
        }
        return expiration;
    }	
}
