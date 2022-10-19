package com.feelthesteel.band.webpage.config.security.auth

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.security.Key
import java.util.Date

@Service
class TokenManager {

    private val validity = 20 * 60 * 1000
    var key: Key = Keys.secretKeyFor(SignatureAlgorithm.HS256)

    fun generateToken(username: String?): String? {
        return Jwts.builder()
            .setSubject(username)
            .setIssuer("AnilOgutveren")
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + validity))
            .signWith(key)
            .compact()
    }

    fun tokenValidate(token: String?): Boolean {
        return getUsernameToken(token) != null && isExpired(token)
    }

    fun getUsernameToken(token: String?): String? {
        val claims: Claims = getClaims(token)
        return claims.getSubject()
    }

    fun isExpired(token: String?): Boolean {
        val claims: Claims = getClaims(token)
        return claims.getExpiration().after(Date(System.currentTimeMillis()))
    }

    private fun getClaims(token: String?): Claims {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody()
    }
}
