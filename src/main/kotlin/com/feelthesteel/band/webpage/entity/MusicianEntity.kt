package com.feelthesteel.band.webpage.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "musicians")
data class MusicianEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,

    @Column(nullable = false, unique = true)
    val name: String,

    @OneToMany // (mappedBy = "musicianEntity", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "musician_id")
    val equipments: Set<EquipmentEntity>?
)
