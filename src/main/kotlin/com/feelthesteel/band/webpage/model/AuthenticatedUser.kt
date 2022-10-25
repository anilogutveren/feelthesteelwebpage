package com.feelthesteel.band.webpage.model

import com.feelthesteel.band.webpage.entity.WebUsers
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthenticatedUser : UserDetails {

    private var webUsers: WebUsers

    constructor(webUsers: WebUsers) {
        this.webUsers = webUsers
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities: MutableList<GrantedAuthority> = ArrayList()
        authorities.add(SimpleGrantedAuthority(webUsers.role.toString()))
        return authorities
    }

    override fun getPassword(): String {
        return webUsers.password
    }

    override fun getUsername(): String {
        return webUsers.username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
