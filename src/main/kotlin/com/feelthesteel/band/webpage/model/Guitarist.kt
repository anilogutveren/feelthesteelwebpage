package com.feelthesteel.band.webpage.model

/**
* Abstract class lar implemente ettikleri interface in tüm methodlarini override etmek zorunda degillerdir
*
* */
abstract class Guitarist() : Musician {

    @Override
    override fun playInstrument() = println("Function Body for abstract method")

    abstract fun plugInSpeakers()

    fun live() { println("Guitarist can play live") }
}
