package com.example.kuisrambulalulintas.data

import com.example.kuisrambulalulintas.model.DataSoal
import com.example.kuisrambulalulintas.utils.Resource

interface MainRepository {

    fun getKuis(resul : (Resource<List<DataSoal>>) -> Unit)
}