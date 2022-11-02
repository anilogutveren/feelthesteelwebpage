package com.feelthesteel.band.webpage.dto

import javax.validation.constraints.NotNull
import lombok.EqualsAndHashCode

@EqualsAndHashCode(of = ["id"])
data class MusicianDto(

    val id: Long,

    @NotNull
    val name: String,

    val equipments: String
)
