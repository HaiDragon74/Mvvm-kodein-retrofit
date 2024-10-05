package com.example.dependencykoin.di

import android.app.Application
import com.example.dependencykoin.Eat
import com.example.dependencykoin.Fly
import com.example.dependencykoin.Pilot
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MyModule():Application(),KodeinAware {
    private val module=Kodein.Module(
        "module",
        allowSilentOverride = true
    ){
        import(androidXModule(this@MyModule))
        bind<Repository>() with singleton { Repository((instance())) }
    }
    override val kodein: Kodein=Kodein.lazy {
        import(module)
        bind<Eat>() with singleton { Eat() }
        bind<Fly>() with singleton { Fly() }
        bind<Pilot>() with singleton { Pilot(instance(),instance()) }
        //viewmodel
/*        bind() from provider { Spla }*/
    }
}