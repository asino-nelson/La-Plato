package com.example.laplato.presentation.mealViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laplato.data.repository.MealRepo
import com.example.laplato.domain.model.MealItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MealViewModel @Inject constructor(
    private val mealRepo: MealRepo
) :ViewModel(){

    private val _state = MutableStateFlow(emptyList<MealItem>())
    val state : StateFlow<List<MealItem>>
        get() = _state

    init {
        viewModelScope.launch {
            val meals = mealRepo.getMeals()
            _state.value = meals
        }
    }
}