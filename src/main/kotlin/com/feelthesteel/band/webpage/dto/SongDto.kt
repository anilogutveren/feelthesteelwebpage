package com.feelthesteel.band.webpage.dto

import javax.validation.constraints.NotNull
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
data class SongDto(

    var id: Long?,

    @NotNull
    var songName: String,

    var songsGenre: String,

    var songsYear: Long,

    var isCovered: Boolean
)
