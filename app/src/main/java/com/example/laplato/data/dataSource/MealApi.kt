package com.example.laplato.data.dataSource

import com.example.laplato.domain.model.MealItem
import com.example.laplato.domain.utils.Constants.END_POINT
import retrofit2.http.GET

interface MealApi {

    @GET(END_POINT)
    suspend fun getMeals():List<MealItem>

}