package com.feelthesteel.band.webpage.dto

import com.feelthesteel.band.webpage.entity.EquipmentEntity
import javax.validation.constraints.NotNull
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.EqualsAndHashCode
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = ["id"])
data class MusicianDto(

    val id: Long,

    @NotNull
    val name: String,

    val equipments: Set<EquipmentEntity>
)
