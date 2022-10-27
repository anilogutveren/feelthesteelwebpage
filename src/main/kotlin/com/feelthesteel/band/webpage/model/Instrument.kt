package com.feelthesteel.band.webpage.model

import javax.persistence.Embeddable

/*
 * Enum is used
 */
enum class Instrument(type: String, brand: String) {
    GUITAR("Normal", "Tender"), DRUM("Acoustic", "Yamaha"), MICROPHONE("Allround", "Sennheiser");

    private lateinit var type: String
    private lateinit var brand: String

    fun Instrument(type: String, brand: String) {
        this.type = type
        this.brand = brand
    }
}
