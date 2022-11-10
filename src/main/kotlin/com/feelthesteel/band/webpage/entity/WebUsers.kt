package com.feelthesteel.band.webpage.entity

import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "webusers")
data class WebUsers(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,

    @Column(unique = true)
    var username: String,

    @Column
    var password: String,

    @Embedded
    var role: Roles
)
