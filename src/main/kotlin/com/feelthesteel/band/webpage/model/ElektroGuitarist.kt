package com.feelthesteel.band.webpage.model

import java.lang.invoke.VarHandle

/**
 *
 * Bu sinifta init getter ve setter methodlari kullanildi.
 *
 * Set methodu asagidaki gibi kullanilabilir
 * */

class ElektroGuitarist(var fullname: String) : Guitarist() {

    init {
        fullname = "Axel"
        println(fullname)
    }

    override fun plugInSpeakers() {
        println("Electro guitarist plugs in this guitar")
    }

    companion object {
        var birthDay: String = ""
        fun play() = println("playing electro guitar")
    }

    override var name: String
        get() = this.fullname
        set(value) {
            this.fullname = value
        }
}
