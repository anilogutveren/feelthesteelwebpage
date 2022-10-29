package com.feelthesteel.band.webpage.model

class Singer(var fullname: String) : Musician {
    init {
        fullname = "Patrick"
        println(fullname)
    }

    override var name: String
        get() = this.fullname
        set(value) {
            this.fullname = if (value == "Patrick") {
                "Patrick the Greatest"
            } else {
                "Unkknown singer"
            }
        }

    @Override
    override fun playInstrument() = println("Our singer $fullname sings with  " + Instrument.Microphone("Sennheiser") + " microphone")
}
