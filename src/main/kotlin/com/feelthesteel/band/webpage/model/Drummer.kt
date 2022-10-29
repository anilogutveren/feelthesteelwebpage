package com.feelthesteel.band.webpage.model

/*
* Burada Kotlin constructor kullanildi.
* Kotlin de constructor ve init asagidaki gibi tanimlanabilir
* */
class Drummer(var fullname: String) : Musician {

    init {
        fullname = "Anil"
        println(fullname)
    }

    companion object {
        var birthDay: String? = ""
        fun play() = println("Playing drums")
        fun learnNewSong() = println("Learning new song")
    }

    override val name: String
        get() = this.fullname

    @Override
    override fun playInstrument() = println("Drummer " + name + " plays " + Instrument.Drums("Acoustic", "Yamaha") + " drums")
}

/*// For Test Purposes
fun main(args: Array<String>) {
    var drummer = Drummer("Anil")
    drummer.printInfo()
    drummer.playInstrument()
}*/
