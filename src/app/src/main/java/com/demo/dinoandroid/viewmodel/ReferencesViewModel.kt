package com.demo.dinoandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReferencesViewModel: ViewModel() {
    val referenceSelected = MutableLiveData(false)
}