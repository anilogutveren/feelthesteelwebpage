package com.feelthesteel.band.webpage.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "songs")
data class SongEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "songname")
    var songname: String,

    @Column(name = "songgenre")
    var songgenre: String,

    @Column(name = "songyear")
    var songyear: Long,

    @Column(name = "iscovered")
    var isCovered: Boolean
)
