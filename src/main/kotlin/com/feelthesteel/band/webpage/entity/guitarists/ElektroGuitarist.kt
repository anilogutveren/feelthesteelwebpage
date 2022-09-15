package com.feelthesteel.band.webpage.entity.guitarists

import com.feelthesteel.band.webpage.entity.Guitarist

/**
 *
 * Bu sinifta init getter ve setter methodlari kullanildi.
 *
 * Set methodu asagidaki gibi kullanilabilir
 * */

class ElektroGuitarist(var fullname: String) : Guitarist() {

    init {
        fullname = "Patrick"
        println(fullname)
    }

    override fun plugInSpeakers() {
        println("Electro guitarist plugs in this guitar")
    }

    override var name: String
        get() = this.fullname
        set(value) {
            this.fullname = value
        }
}
