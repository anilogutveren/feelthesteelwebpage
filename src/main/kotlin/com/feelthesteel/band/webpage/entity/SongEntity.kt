package com.feelthesteel.band.webpage.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import lombok.Builder

@Entity
@Table(name = "songsTable")
data class SongEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "songName")
    var songName: String,

    @Column(name = "songGenre")
    var songsGenre: String,

    @Column(name = "songsYear")
    var songsYear: Long,

    @Column(name = "isCovered")
    var isCovered: Boolean
)
