package com.feelthesteel.band.webpage.controller

import com.feelthesteel.band.webpage.entity.Instrument
import com.feelthesteel.band.webpage.entity.MusicianEntity
import com.feelthesteel.band.webpage.service.IMusicianService
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class MusicianController(
    private val musicianService: IMusicianService
) {
    @GetMapping("/musicians")
    fun getAllMusicians(): ResponseEntity<MutableList<MusicianEntity>> {
        return ResponseEntity.ok(musicianService.getAllMusicians())
    }

/*    @GetMapping("/musicians/{name}/{instrument}")
    fun getMusicianByNameAndInstrument(
        @RequestParam name: String,
        @RequestParam instrument: Instrument
    ): ResponseEntity<MusicianEntity> {
        return ResponseEntity.ok(musicianService.findMusicianByNameAndInstrument(name, instrument))
    }*/

    @DeleteMapping("/deleteAllMusicians")
    fun deleteAllMusicians(): ResponseEntity<Any> {
        return ResponseEntity.ok(musicianService.deleteAllMusicians())
    }

    @PostMapping("/registerNewMusician")
    fun registerNewMusician(@RequestBody musicianEntity: MusicianEntity): ResponseEntity<Any> {
        return ResponseEntity.ok(musicianService.saveMusician(musicianEntity))
    }
}
