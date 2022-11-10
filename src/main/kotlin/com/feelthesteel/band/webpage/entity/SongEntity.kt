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
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,

    @Column(name = "song_Name")
    var songName: String,

    @Column(name = "song_Genre")
    var songsGenre: String,

    @Column(name = "song_Year")
    var songsYear: Long,

    @Column(name = "is_Covered")
    var isCovered: Boolean
)
