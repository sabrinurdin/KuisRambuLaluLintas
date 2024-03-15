package com.example.kuisrambulalulintas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kuisrambulalulintas.data.MainRepository
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import com.example.kuisrambulalulintas.model.DataSoal
import com.example.kuisrambulalulintas.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _readHistory = MutableLiveData<List<HistoryEntity>?>(emptyList())
    val readHistory: MutableLiveData<List<HistoryEntity>?>
        get() = _readHistory


    private val _soal = MutableLiveData<Resource<List<DataSoal>>>()
    val soal : MutableLiveData<Resource<List<DataSoal>>>
    get() = _soal


    fun getKuis(){

        _soal.value = Resource.Loading()
        mainRepository.getKuis {
            _soal.value = it
        }
    }

    fun addHistory(name: String,score: Int){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.addHistory(name, score)
        }
    }

    fun getAllHistory(){
        viewModelScope.launch(Dispatchers.IO){
            mainRepository.getAllHistory().collect{
                _readHistory.postValue(it)
            }
        }
    }

}