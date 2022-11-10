package com.feelthesteel.band.webpage.entity.mapper

import com.feelthesteel.band.webpage.dto.MusicianDto
import com.feelthesteel.band.webpage.entity.MusicianEntity

object MusicianEntitytoDtoMapper {
    fun MusicianEntity.toMusicianDto() = MusicianDto(
        id = this.id,
        name = this.name,
        equipments = this.equipments
    )
}