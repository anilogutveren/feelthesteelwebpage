package com.feelthesteel.band.webpage.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "userTable")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    var id: Long,

    @Column(unique = true)
    var username: String,

    @Column
    var password: String,

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    var role: Set<RolesEntity>
)
