package com.feelthesteel.band.webpage.controller

import com.feelthesteel.band.webpage.entity.SongEntity
import com.feelthesteel.band.webpage.service.ISongsService
import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@RequestMapping("/songs")
class SongsController(
    private val songsService: ISongsService
) {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/addNewSong", produces = ["application/json"])
    fun saveSong(
        @RequestHeader("X-TrackingId", required = true) trackingId: String,
        @RequestBody songEntity: SongEntity
    ): ResponseEntity<SongEntity> {
        logger.info("Saving the song $songEntity")
        return ResponseEntity.ok(songsService.saveSongs(songEntity))
    }

    @GetMapping("/coveredSongs/{name}", produces = ["application/json"])
    fun getCoveredSongs(
        @RequestHeader("X-TrackingId", required = true) trackingId: String,
        @PathVariable(value = "isCovered", required = true) isCovered: Boolean
    ): ResponseEntity<SongEntity> {
        logger.info("Saving the song $isCovered")
        return ResponseEntity.ok(songsService.findCoveredSongs(isCovered))
    }

    @DeleteMapping("/deleteAllSongs")
    @PreAuthorize("hasRole('ADMIN')")
    fun deleteAllSongs(
        @RequestHeader("X-TrackingId", required = true) trackingId: String
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(songsService.deleteAllSongs())
    }
}
