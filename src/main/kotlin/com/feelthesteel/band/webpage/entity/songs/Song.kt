package com.feelthesteel.band.webpage.entity.songs

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "songsTable")
data class Song(

    @Id
    @GeneratedValue
    var id: Long,

    @Column(name = "songName")
    var songName: String,

    @Column(name = "songNumber")
    var songNumber: Long,

    @Column(name = "songGenre")
    var songGenre: String,

    @Column(name = "songsYear")
    var songsYear: Long,

    @Column(name = "isCoveredSong")
    var isCoveredSong: Boolean

)
