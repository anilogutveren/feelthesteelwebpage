package com.feelthesteel.band.webpage.config.security.auth

import javax.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserAuthDetailsService() : UserDetailsService {

    @Autowired
    private lateinit var passwordEncoder: BCryptPasswordEncoder

    private val users: MutableMap<String, String> = HashMap()

    @PostConstruct
    fun init() {
        users["anil"] = passwordEncoder.encode("123")
    }

    override fun loadUserByUsername(username: String): UserDetails? {
        if (users.containsKey(username)) {
            return User(username, users[username], ArrayList())
        }
        throw UsernameNotFoundException(username)
    }
}
