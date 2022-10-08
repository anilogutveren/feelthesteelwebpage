package com.feelthesteel.band.webpage.entity

import com.feelthesteel.band.webpage.model.Instrument
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "musicianTable")
data class MusicianEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(name = "name", nullable = false, unique = true)
    val name: String,

    @Enumerated(EnumType.STRING)
    val instrument: Instrument

)
