package com.feelthesteel.band.webpage.controller

import com.feelthesteel.band.webpage.dto.MusicianDto
import com.feelthesteel.band.webpage.service.impl.MusiciansServiceImpl
import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class MusicianController(
    private val musicianService: MusiciansServiceImpl
) {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/musicians", produces = ["application/json"])
    fun getAllMusicians(
        @RequestHeader("X-TrackingId", required = true) trackingId: String
    ): ResponseEntity<MutableList<MusicianDto>> {
        return ResponseEntity.ok(musicianService.getAllMusicians())
    }

    @GetMapping("/musicians/{name}")
    fun getMusicianByName(
        @RequestHeader("X-TrackingId", required = true) trackingId: String,
        @PathVariable(value = "name", required = false) name: String
    ): ResponseEntity<MusicianDto> {
        logger.info("Searching musician with name $name")
        return ResponseEntity.ok(musicianService.findMusicianByName(name))
    }

    @DeleteMapping("/deleteAllMusicians")
    fun deleteAllMusicians(
        @RequestHeader("X-TrackingId", required = true) trackingId: String
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(musicianService.deleteAllMusicians())
    }

    @PostMapping("/registerNewMusician")
    fun registerNewMusician(
        @RequestHeader("X-TrackingId", required = true) trackingId: String,
        @RequestBody musicianDto: MusicianDto
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(musicianService.saveMusician(musicianDto))
    }

    @PostMapping("/registerMultipleMusicians")
    fun registerNewMusicians(
        @RequestHeader("X-TrackingId", required = true) trackingId: String,
        @RequestBody musicianDtos: List<MusicianDto>
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(musicianService.saveMultipleMusicians(musicianDtos))
    }

    @PutMapping("/updateMusician")
    fun updateMusicians(
        @RequestHeader("X-TrackingId", required = true) trackingId: String,
        @RequestBody musicianDto: MusicianDto
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(musicianService.updateMusician(musicianDto))
    }
}
