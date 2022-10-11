package com.feelthesteel.band.webpage.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

/*@SQLInsert(
    sql = "INSERT INTO authorities(id, name) values (1, 'WRITE')"
)*/
@Entity
@Table(name = "authorities")
class AuthoritiesEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0,

    @Column(name = "role", unique = true)
    val role: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    private val user: UserEntity
)
