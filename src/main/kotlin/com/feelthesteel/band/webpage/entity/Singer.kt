package com.feelthesteel.band.webpage.entity

class Singer(name: String, type: String) : Musician(name, type) {

    @Override
    override fun playInstrument() = println("Our singer sings with  " + Instrument.MICROPHONE + " microphone")
}