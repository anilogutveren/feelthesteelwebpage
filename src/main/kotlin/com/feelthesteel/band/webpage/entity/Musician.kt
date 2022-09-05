package com.feelthesteel.band.webpage.entity

/**
 * Used Methods:
 * Abstract Classes and methods
 *
 *
 */

abstract class Musician(var name: String, var type: String) {

/*    lateinit var name: String
    lateinit var type: String

    init{
        this.name = name
        this.type = type
    }*/

    open fun playInstrument() = println("Musician plays instrument")

    fun printInfo() {
        println("Musicians meetup")
    }
}
