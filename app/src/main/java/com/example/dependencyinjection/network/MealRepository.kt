package com.example.dependencyinjection.network

import com.example.dependencyinjection.model.ListMeal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MealRepository (private val apiService: ApiService):MealRepositorySource
{
    override fun getMeal(): Flow<ListMeal> {
        return flow {
            val data =apiService.getMeal()
            emit(data)
        }.flowOn(Dispatchers.IO)
    }

    override fun getUser(): Flow<ListMeal> {
        TODO("Not yet implemented")
    }


}