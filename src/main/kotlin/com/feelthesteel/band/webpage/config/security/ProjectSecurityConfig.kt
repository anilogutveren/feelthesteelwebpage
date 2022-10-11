package com.feelthesteel.band.webpage.config.security

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource

/**
 * Burada Spring Security kullanildi.
 * UserDetailService hem InMemory hem de JDBC olarak implemente edildi.
 * **/

@EnableWebSecurity(debug = true)
@Configuration
class ProjectSecurityConfig {

    @Order(1)
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        // Create JWT Token
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

        // Disable Frame Options for Vue Js frontend
        http.headers().frameOptions().disable()

        // Add some matchers
        http.cors().and().csrf().disable().authorizeRequests()
            .antMatchers("/musicians/**").authenticated()
            .antMatchers("/songs/coveredSongs").authenticated()
            .antMatchers("/songs/addNewSong").hasAuthority("ADMIN")
            .antMatchers("/deleteAllSongs").hasRole("ADMIN")
            .antMatchers("/deleteAllMusicians").hasRole("ADMIN")
            .antMatchers("/registerMultipleMusicians").hasRole("ADMIN")
            .anyRequest().permitAll()
            .and()
            .httpBasic()
        return http.build()
    }

    @Bean
    @ConditionalOnProperty(value = ["security.jwt.enabled"], havingValue = "false")
    fun corsWebFilter(): CorsWebFilter {
        val corsConfig = CorsConfiguration()
        corsConfig.allowedOrigins = listOf("http://localhost:8082")
        corsConfig.maxAge = 300000L
        corsConfig.addAllowedMethod("*")
        corsConfig.addAllowedHeader("*")
        corsConfig.addExposedHeader("Authorization")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfig)
        return CorsWebFilter(source)
    }

    @Bean("bcrypt")
    fun getBCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder(16)
    }

    @Bean("noops")
    fun getNoOpPasswordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }

    /*
        @Bean
        fun userDetailsService(): UserDetailsService {
            val user = User.builder()
                .username("user")
                .password("{bcrypt}password")
                .roles("USER")
                .build()
            val admin = User.builder()
                .username("admin")
                .password("{bcrypt}12345").authorities("ADMIN")
                .roles("USER", "ADMIN")
                .build()
            return InMemoryUserDetailsManager(user, admin)
        } HERE I TESTED INMEMORYUSERDETAILSMANAGER*/
}
