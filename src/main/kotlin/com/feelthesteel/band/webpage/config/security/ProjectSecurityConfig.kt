package com.feelthesteel.band.webpage.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

/**
 * Burada Spring Security kullanildi.
 * UserDetailService hem InMemory hem de JDBC olarak implemente edildi.
 * **/

// @EnableWebSecurity
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

    @Order(1)
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.headers().frameOptions().disable()
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
