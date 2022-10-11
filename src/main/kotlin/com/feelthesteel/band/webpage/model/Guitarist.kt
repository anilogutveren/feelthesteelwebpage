package com.feelthesteel.band.webpage.model

/**
* Abstract class lar implemente ettikleri interface in tüm methodlarini override etmek zorunda degillerdir
*
* */
abstract class Guitarist() : Musician {

    @Override
    override fun playInstrument() = println("Guitarists play " + Instrument.GUITAR + " guitar")

    abstract fun plugInSpeakers()

    fun playsLive() { println("Guitarist can play live") }
}
