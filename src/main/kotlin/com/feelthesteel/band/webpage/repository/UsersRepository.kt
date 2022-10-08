package com.feelthesteel.band.webpage.repository

import com.feelthesteel.band.webpage.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UsersRepository : CrudRepository<UserEntity, Long> {
    fun findByUsername(username: String?): UserEntity
}
