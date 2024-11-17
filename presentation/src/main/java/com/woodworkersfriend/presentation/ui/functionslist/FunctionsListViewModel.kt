package com.woodworkersfriend.presentation.ui.functionslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FunctionsListViewModel @Inject constructor() : ViewModel() {
    fun init() {
        viewModelScope.launch {

        }
    }
}