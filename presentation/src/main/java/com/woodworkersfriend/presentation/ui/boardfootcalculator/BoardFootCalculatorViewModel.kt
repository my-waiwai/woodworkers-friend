package com.woodworkersfriend.presentation.ui.boardfootcalculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoardFootCalculatorViewModel @Inject constructor() : ViewModel() {
    fun init() {
        viewModelScope.launch {

        }
    }
}