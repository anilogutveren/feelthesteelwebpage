package com.feelthesteel.band.webpage.repository

import com.feelthesteel.band.webpage.entity.WebUsers
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository : JpaRepository<WebUsers, Long> {
    fun findByUsername(username: String?): WebUsers
}
