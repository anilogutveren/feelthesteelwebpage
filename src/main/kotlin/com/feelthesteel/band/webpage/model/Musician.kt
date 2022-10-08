package com.feelthesteel.band.webpage.model

/**
 * Used Methods:
 * Interface with default methods
 *
 * We implemented the playInstrument and printInfo methods in this interface. +
 * So these methods are defined as default methods.
 */

interface Musician {
    val name: String
    fun playInstrument() = println("Musician plays instrument")

    fun printInfo() {
        println("Musicians meetup")
    }
}
