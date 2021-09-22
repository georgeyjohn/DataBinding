package com.internal.databinding.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.internal.databinding.model.AcronymDetails
import com.internal.databinding.repository.AcronymRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class MainViewModel: ViewModel() {

    val acronymData = MutableLiveData<List<AcronymDetails>>()
    val searchText = MutableLiveData<String>()
    var showError = MutableLiveData<String>()

    fun search(searchString: String) {
        CoroutineScope(Dispatchers.IO ).launch {
            AcronymRepository().getAcronymList(searchString).collect {
                if(it.isNullOrEmpty()) {
                    showError.postValue("No Data to show")
                    acronymData.postValue (arrayListOf())
                } else {
                    searchText.postValue("")
                    acronymData.postValue (it[0]?.acronymDetails as List<AcronymDetails>)
                }
            }
        }
    }

}