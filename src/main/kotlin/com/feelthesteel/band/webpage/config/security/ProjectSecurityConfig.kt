package com.feelthesteel.band.webpage.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.web.SecurityFilterChain

/**
 * Burada Spring Security kullanildi.
 * UserDetailService hem InMemory hem de JDBC olarak implemente edildi.
 * Noops Encryption is deprecated.
 * **/

@EnableWebSecurity(debug = true)
@Configuration
class ProjectSecurityConfig {

    @Bean("bcrypt")
    fun getBCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder(16)
    }

    @Bean("noops")
    fun getNoOpPasswordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }

    @Bean
    fun defaultSecurityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests().anyRequest().authenticated().and().oauth2Login()
        return http.build()
    }

    @Bean
    fun clientRegistrationRepository(): ClientRegistrationRepository {
        return InMemoryClientRegistrationRepository(clientGitHubRegistration())
    }

    private fun clientGitHubRegistration(): ClientRegistration {
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
            .clientId("f71d3b77187a81a4c19b")
            .clientSecret("98558fcef71d82599a4be38635f427e207498553")
            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
            .redirectUri("{baseUrl}/{action}/oauth2/code/{registrationId}")
            .build()
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
