package com.feelthesteel.band.webpage.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
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

    @Column(name = "name", unique = true)
    val username: String,

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String,

    @Column
    var role: String,

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    val authorities: List<AuthoritiesEntity>
)
