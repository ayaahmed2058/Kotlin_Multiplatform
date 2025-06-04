package com.example.firstappkmp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual open class BaseViewModel : ViewModel(){

    actual var scope : CoroutineScope = viewModelScope

}