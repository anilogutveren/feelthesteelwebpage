package com.feelthesteel.band.webpage.service.impl.auth

import com.feelthesteel.band.webpage.entity.AuthoritiesEntity
import com.feelthesteel.band.webpage.entity.UserEntity
import com.feelthesteel.band.webpage.repository.UsersRepository
import javax.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class FtsWebAppUserDetailsImpl(
    @Autowired
    val usersRepository: UsersRepository,
    @Qualifier("noops") @Autowired
    val passwordEncoder: PasswordEncoder
) : UserDetailsService {

/*    @PostConstruct
    fun init() {
        usersRepository.save(UserEntity(1, "admin", passwordEncoder.encode("12345"), "ADMIN", emptyList()))
    }*/

    override fun loadUserByUsername(username: String?): UserDetails {
        val userEntity: UserEntity = usersRepository.findByUsername(username)
        if (userEntity.username.equals(null)) {
            throw UsernameNotFoundException(username)
        }
        return User(userEntity.username, userEntity.password, ArrayList())
    }
}
