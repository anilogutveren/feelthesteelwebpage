package com.feelthesteel.band.webpage.config.security.auth

import com.feelthesteel.band.webpage.entity.WebUsers
import com.feelthesteel.band.webpage.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class UserAuthDetailsService : UserDetailsService {

/*    @Autowired
    private lateinit var usersRepository: UsersRepository*/

    private var passwordEncoder: BCryptPasswordEncoder = BCryptPasswordEncoder()

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

/*    fun loadUserByWebUsername(username: String?): UserDetails {
        val webUsers: WebUsers = usersRepository.findByUsername(username)
        if (webUsers.username.equals(null)) {
            throw UsernameNotFoundException(username)
        }
        return User(webUsers.username, webUsers.password, ArrayList())
    }*/

    fun addNewUser(webUsers: WebUsers) {
        users[webUsers.username] = webUsers.password
    }

/*    fun addNewWebUser(webUsers: WebUsers) {
        usersRepository.save(webUsers)
    }*/
}
