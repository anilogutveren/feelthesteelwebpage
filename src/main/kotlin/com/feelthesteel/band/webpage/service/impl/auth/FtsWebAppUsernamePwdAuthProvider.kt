package com.feelthesteel.band.webpage.service.impl.auth

import com.feelthesteel.band.webpage.entity.UserEntity
import com.feelthesteel.band.webpage.repository.UsersRepository
import javax.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class FtsWebAppUsernamePwdAuthProvider(
    @Autowired
    val usersRepository: UsersRepository,
    @Qualifier("bcrypt") @Autowired
    val passwordEncoder: BCryptPasswordEncoder
) : AuthenticationProvider {

    @PostConstruct
    fun init() {
        usersRepository.save(UserEntity(1, "admin", passwordEncoder.encode("12345"), "ADMIN"))
    }

    override fun authenticate(authentication: Authentication?): Authentication {
        val username = authentication?.name
        val password = authentication?.credentials.toString()
        val user = usersRepository.findByUsername(username)
        if (!user.toString().isNullOrEmpty()) {
            if (passwordEncoder.matches(password, user.password)) {
                val authorities: MutableList<GrantedAuthority> = ArrayList()
                authorities.add(SimpleGrantedAuthority(user.role))
                return UsernamePasswordAuthenticationToken(username, password, authorities)
            } else {
                throw BadCredentialsException("Invalid password!")
            }
        } else {
            throw BadCredentialsException("No user registered with this details!")
        }
    }

/*    private fun getGrantedAuthorities(authorities: Set<Autho>): List<GrantedAuthority>? {
        val grantedAuthorities: MutableList<GrantedAuthority> = java.util.ArrayList()
        for (authority in authorities) {
            grantedAuthorities.add(SimpleGrantedAuthority(authority.getName()))
        }
        return grantedAuthorities
    }*/

    override fun supports(authentication: Class<*>?): Boolean {
        return authentication!!.equals(UsernamePasswordAuthenticationToken::class.java)
    }
}
