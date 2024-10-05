package com.example.dependencykoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity() : AppCompatActivity(),KodeinAware {

    override val kodein: Kodein by closestKodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pilot:Pilot by kodein.instance()
        Log.d("HAHAHAHHAHA",pilot.pefrorm())

    }

}