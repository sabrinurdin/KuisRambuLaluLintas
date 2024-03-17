package com.example.kuisrambulalulintas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kuisrambulalulintas.data.MainRepository
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity2
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity3
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity4
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity5
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

    private val _readHistory2 = MutableLiveData<List<HistoryEntity2>?>(emptyList())
    val readHistory2: MutableLiveData<List<HistoryEntity2>?>
        get() = _readHistory2

    private val _readHistory3 = MutableLiveData<List<HistoryEntity3>?>(emptyList())
    val readHistory3: MutableLiveData<List<HistoryEntity3>?>
        get() = _readHistory3

    private val _readHistory4 = MutableLiveData<List<HistoryEntity4>?>(emptyList())
    val readHistory4: MutableLiveData<List<HistoryEntity4>?>
        get() = _readHistory4

    private val _readHistory5 = MutableLiveData<List<HistoryEntity5>?>(emptyList())
    val readHistory5: MutableLiveData<List<HistoryEntity5>?>
        get() = _readHistory5




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

    fun addHistory2(name: String,score: Int){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.addHistory2(name, score)
        }
    }

    fun addHistory3(name: String,score: Int){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.addHistory3(name, score)
        }
    }

    fun addHistory4(name: String,score: Int){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.addHistory4(name, score)
        }
    }

    fun addHistory5(name: String,score: Int){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.addHistory5(name, score)
        }
    }

    fun getAllHistory(){
        viewModelScope.launch(Dispatchers.IO){
            mainRepository.getAllHistory().collect{
                _readHistory.postValue(it)
            }
        }
    }

    fun getAllHistory2(){
        viewModelScope.launch(Dispatchers.IO){
            mainRepository.getAllHistory2().collect{
                _readHistory2.postValue(it)
            }
        }
    }

    fun getAllHistory3(){
        viewModelScope.launch(Dispatchers.IO){
            mainRepository.getAllHistory3().collect{
                _readHistory3.postValue(it)
            }
        }
    }

    fun getAllHistory4(){
        viewModelScope.launch(Dispatchers.IO){
            mainRepository.getAllHistory4().collect{
                _readHistory4.postValue(it)
            }
        }
    }

    fun getAllHistory5(){
        viewModelScope.launch(Dispatchers.IO){
            mainRepository.getAllHistory5().collect{
                _readHistory5.postValue(it)
            }
        }
    }

}