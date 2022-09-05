package com.feelthesteel.band.webpage.entity

class Drummer(name: String, type: String) : Musician(name, type) {

    @Override
    override fun playInstrument() = println("Drummer play " + Instrument.DRUM + " drums")
}
