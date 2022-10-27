package com.feelthesteel.band.webpage.entity

import com.feelthesteel.band.webpage.model.Instrument
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "equipment")
data class EquipmentEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,

    @Enumerated(EnumType.STRING)
    val instrument: Instrument,

    @ManyToOne
    @JoinColumn(name = "musician_id")
    val musicianEntity: MusicianEntity
)
