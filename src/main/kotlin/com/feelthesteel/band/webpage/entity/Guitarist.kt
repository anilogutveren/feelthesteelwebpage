package com.feelthesteel.band.webpage.entity

class Guitarist(name: String, type: String) : Musician(name, type) {

    @Override
    override fun playInstrument() = println("Guitarists play " + Instrument.GUITAR + " guitar")
}
