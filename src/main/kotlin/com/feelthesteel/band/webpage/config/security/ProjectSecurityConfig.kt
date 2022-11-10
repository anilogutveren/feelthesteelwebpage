package com.feelthesteel.band.webpage.config.security

import com.feelthesteel.band.webpage.config.security.auth.JwtTokenFilter
import com.feelthesteel.band.webpage.config.security.auth.UserAuthDetailsService
import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
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

/**
 * Burada Spring Security kullanildi.
 * UserDetailService hem InMemory hem de JDBC olarak implemente edildi.
 * **/

@Configuration
@EnableWebSecurity(debug = true)
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

        http.cors().disable().csrf().disable()
            .authorizeRequests()
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

    /*    @Bean("bcrypt")
        fun getBCryptPasswordEncoder(): BCryptPasswordEncoder {
            return BCryptPasswordEncoder(16)
        }

        @Bean("noops")
        fun getNoOpPasswordEncoder(): PasswordEncoder {
            return NoOpPasswordEncoder.getInstance()
        }*/
}
