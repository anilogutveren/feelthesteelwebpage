package com.feelthesteel.band.webpage.entity

/*
* Burada Kotlin constructor kullanildi.
* Kotlin de constructor ve init asagidaki gibi tanimlanabilir
* */
class Drummer(var fullname: String) : Musician {

    init {
        fullname = "Anil Oeguetveren"
        println(fullname)
    }

    override val name: String
        get() = this.fullname

    @Override
    override fun playInstrument() = println("Drummer " + name + " plays " + Instrument.DRUM + " drums")
}

/*// For Test Purposes
fun main(args: Array<String>) {
    var drummer = Drummer("Anil")
    drummer.printInfo()
    drummer.playInstrument()
}*/
