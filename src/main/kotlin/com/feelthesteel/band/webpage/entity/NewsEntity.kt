package com.feelthesteel.band.webpage.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class NewsEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,

    val news: String
)
