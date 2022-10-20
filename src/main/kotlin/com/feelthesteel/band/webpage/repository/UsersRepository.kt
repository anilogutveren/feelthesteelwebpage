package com.feelthesteel.band.webpage.repository

import com.feelthesteel.band.webpage.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository : JpaRepository<UserEntity, Long> {
    fun findByUsername(username: String?): UserEntity
}
