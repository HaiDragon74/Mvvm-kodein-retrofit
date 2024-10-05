package com.example.dependencyinjection.di

import android.app.Application
import com.example.dependencyinjection.MyViewModel
import com.example.dependencyinjection.network.ApiService
import com.example.dependencyinjection.network.MealRepository
import com.example.dependencyinjection.network.MealRepositorySource
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Module():Application(),KodeinAware {
    private val module=Kodein.Module(
        "module",
        allowSilentOverride = true
    ){
        import(androidXModule(this@Module))
        bind<RepositoryModule>() with singleton { RepositoryModule((instance())) }
    }
    override val kodein: Kodein=Kodein.lazy {
        import(module)
        bind<ApiService>() with singleton {
            val retrofit= Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(ApiService::class.java)
        }
        bind<MealRepositorySource>() with singleton { MealRepository(instance()) }
        bind<MyViewModel>() with provider { MyViewModel(instance()) }
/*        //viewmodel class
        bind<MealRepository>() with singleton { MealRepository(instance()) }*/
    }
}