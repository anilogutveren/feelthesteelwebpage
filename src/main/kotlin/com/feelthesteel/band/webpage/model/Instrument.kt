package com.feelthesteel.band.webpage.model

/*
 * Enum is used
 */
sealed class Instrument {
    data class Drums(val type: String, val brand: String)
    data class Guitar(val type: String, val brand: String, val amountOfPedals: Int)
    data class Microphone(val brand: String)
    object None : Instrument()

/*    GUITAR("Normal", "Tender"), DRUM("Acoustic", "Yamaha"), MICROPHONE("Allround", "Sennheiser");

    private lateinit var type: String
    private lateinit var brand: String

    fun Instrument(type: String, brand: String) {
        this.type = type
        this.brand = brand
    }*/
}
