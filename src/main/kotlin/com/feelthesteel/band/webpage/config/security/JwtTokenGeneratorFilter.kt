package com.feelthesteel.band.webpage.config.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import java.util.Date
import javax.crypto.SecretKey
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtTokenGeneratorFilter : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val authentication = SecurityContextHolder.getContext().authentication
        if (null != authentication) {
            val key: SecretKey = Keys.hmacShaKeyFor("jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4".toByteArray(StandardCharsets.UTF_8))
            val jwt: String = Jwts.builder()
                .setIssuer("Fts")
                .setSubject("JWT Token")
                .claim("username", authentication.name)
                .claim("authorities", populateAuthorities(authentication.authorities))
                .setIssuedAt(Date())
                .setExpiration(Date(Date().time + 300000000))
                .signWith(key).compact()
            response.setHeader("Authorization", jwt)
        }
        filterChain.doFilter(request, response)
    }

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        return request.servletPath != "/user"
    }

    private fun populateAuthorities(collection: Collection<GrantedAuthority>): String? {
        val authoritiesSet: MutableSet<String> = HashSet()
        for (authority in collection) {
            authoritiesSet.add(authority.authority)
        }
        return java.lang.String.join(",", authoritiesSet)
    }
}
