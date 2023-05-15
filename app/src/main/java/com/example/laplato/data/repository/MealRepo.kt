package com.example.laplato.data.repository

import com.example.laplato.data.dataSource.MealApi
import com.example.laplato.domain.model.MealItem
import javax.inject.Inject

class MealRepo @Inject constructor(
    private val mealApi: MealApi
) {

    suspend fun getMeals():List<MealItem>{
        return mealApi.getMeals()
    }

}