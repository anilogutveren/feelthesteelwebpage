package com.feelthesteel.band.webpage.config.security.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtTokenFilter(
    @Autowired
    private val tokenManager: TokenManager
) : OncePerRequestFilter() {

    override fun doFilterInternal(httpServletRequest: HttpServletRequest, httpServletResponse: HttpServletResponse, filterChain: FilterChain) {
        val authHeader: String? = httpServletRequest.getHeader("Authorization")

        var username: String? = null
        var token: String? = null

        if (authHeader?.contains("Bearer") == true) {
            token = authHeader.substring(7)
            try {
                username = tokenManager.getUsernameToken(token)
            } catch (e: Exception) {
                println(e.message)
            }
        }

        if (username != null && token != null && SecurityContextHolder.getContext().authentication == null) {
            if (tokenManager.tokenValidate(token)) {
                val userPassToken = UsernamePasswordAuthenticationToken(username, null, ArrayList())
                userPassToken.details = WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
                SecurityContextHolder.getContext().authentication = userPassToken
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse)
    }
}
