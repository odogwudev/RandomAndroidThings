package com.odogwudev.randomandroidthings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

//logic to count Seconds
class StopWatchViewModel : ViewModel() {

    //range to count in application
    val seconds = (0..100)
        .asSequence()   //return each and every second from range whn iterated (lazily)
        .asFlow()   //convert to flow
        .map {
            if (it in 0..9) "0$it" else it//add one zero to numbers that fall into 0 to 9 to prevent alignment
        }
        .onEach { delay(1000) } //delay of one second
}