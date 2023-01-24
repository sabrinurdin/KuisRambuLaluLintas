package com.example.kuisrambulalulintas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kuisrambulalulintas.data.MainRepository
import com.example.kuisrambulalulintas.model.DataSoal
import com.example.kuisrambulalulintas.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {


    private val _soal = MutableLiveData<Resource<List<DataSoal>>>()
    val soal : MutableLiveData<Resource<List<DataSoal>>>
    get() = _soal


    fun getKuis(){

        _soal.value = Resource.Loading()
        mainRepository.getKuis {
            _soal.value = it
        }
    }

}