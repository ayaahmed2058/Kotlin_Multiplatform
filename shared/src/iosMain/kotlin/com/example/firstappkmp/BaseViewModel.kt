package com.example.firstappkmp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

actual open class BaseViewModel {

    actual var scope : CoroutineScope = CoroutineScope(Dispatchers.Main)

}