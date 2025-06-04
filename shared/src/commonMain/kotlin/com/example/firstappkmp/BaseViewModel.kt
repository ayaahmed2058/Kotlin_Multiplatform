package com.example.firstappkmp

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {

    var scope: CoroutineScope


}