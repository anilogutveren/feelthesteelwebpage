package com.feelthesteel.band.webpage.dto

import com.feelthesteel.band.webpage.entity.EquipmentEntity
import javax.validation.constraints.NotNull
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
data class MusicianDto(

    val id: Long,

    @NotNull
    val name: String,

    val equipments: Set<EquipmentEntity>?
)
