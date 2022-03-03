package com.demo.dinoandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PagerViewModel: ViewModel() {
    val goToGameFragment = MutableLiveData(false)
}