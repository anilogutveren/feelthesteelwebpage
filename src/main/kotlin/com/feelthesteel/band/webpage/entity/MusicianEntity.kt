package com.feelthesteel.band.webpage.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "musicianData")
data class MusicianEntity(

    @Column(name = "name", nullable = false, unique = true)
    val name: String,

    @Enumerated(EnumType.STRING)
    val instrument: Instrument,

    @Id
    @GeneratedValue
    private var id: Long
)
