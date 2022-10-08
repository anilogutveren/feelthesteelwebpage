package com.feelthesteel.band.webpage.model

class BassGuitarist(var fullname: String) : Guitarist() {

    init {
        fullname = "Steffen"
        println(fullname)
    }

    override val name: String
        get() = this.fullname

    override fun playInstrument() = println("Drummer " + name + " plays " + Instrument.GUITAR + " drums")

    override fun plugInSpeakers() {
        println("Bass guitarist plugs in this guitar")
    }

    override fun printInfo() {
        println("Bassist Name $name")
    }
}

/*// For Test Purposes
fun main(args: Array<String>) {
    var bassist = BassGuitarist("")
    bassist.fullname = "Steffen"
    bassist.playInstrument()
    bassist.printInfo()
}*/
