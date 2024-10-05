package com.example.dependencykoin

class Pilot(private val eat: Eat,private val fly: Fly) {
    fun pefrorm():String{
        return eat.eatFood() + "\n" + fly.flyPlane()
    }

}