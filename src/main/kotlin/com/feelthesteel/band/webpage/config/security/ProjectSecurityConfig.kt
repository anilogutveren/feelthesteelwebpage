package com.feelthesteel.band.webpage.config.security

import com.feelthesteel.band.webpage.config.security.auth.JwtTokenFilter
import com.feelthesteel.band.webpage.config.security.auth.UserAuthDetailsService
import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource

/**
 * Burada Spring Security kullanildi.
 * UserDetailService hem InMemory hem de JDBC olarak implemente edildi.
 * **/

@Configuration
@EnableWebSecurity//(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
class ProjectSecurityConfig() {

    private val logger: Logger = LoggerFactory.getLogger(ProjectSecurityConfig::class.java)

    @Autowired
    private lateinit var jwtTokenFilter: JwtTokenFilter

    @Autowired
    private lateinit var userAuthDetailsService: UserAuthDetailsService

    @Autowired
    fun configurePasswordEncoder(builder: AuthenticationManagerBuilder) {
        builder.userDetailsService(userAuthDetailsService).passwordEncoder(BCryptPasswordEncoder(16))
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        // Disable Frame Options for Vue Js frontend
        http.headers().frameOptions().disable()

        http.cors().configurationSource { corsConfig().applyPermitDefaultValues() }.and().csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/").permitAll()
            .antMatchers("/h2-console").permitAll()
            .antMatchers("/photo.jpg").permitAll()
            .antMatchers("/users/**").authenticated()
            .antMatchers("/addNewSong").authenticated()
            .antMatchers("/deleteAllSongs").authenticated()
            .antMatchers("/registerNewMusician").authenticated()
            .antMatchers("/registerMultipleMusicians").authenticated()
            .antMatchers("/deleteAllMusicians").authenticated()
            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)


        return http.build()
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager? {
        logger.debug("AuthenticationManager invoked.")
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    @ConditionalOnProperty(value = ["security.jwt.enabled"], havingValue = "false")
    fun corsWebFilter(): CorsWebFilter {
        val corsConfig = corsConfig()
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfig)
        return CorsWebFilter(source)
    }

    private fun corsConfig(): CorsConfiguration {
        val corsConfig = CorsConfiguration()
        corsConfig.maxAge = 80000L
        corsConfig.addAllowedOriginPattern("*")
        corsConfig.allowCredentials = true
        corsConfig.addAllowedMethod("*")
        corsConfig.addAllowedMethod("OPTIONS");
        corsConfig.addAllowedMethod("GET");
        corsConfig.addAllowedMethod("PUT");
        corsConfig.addAllowedMethod("POST");
        corsConfig.addAllowedMethod("DELETE");
        corsConfig.addAllowedMethod("PATCH");
        corsConfig.addAllowedHeader("*")
        return corsConfig
    }
}
/*    @Bean("bcrypt")
    fun getBCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder(16)
    }

    @Bean("noops")
    fun getNoOpPasswordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
*/