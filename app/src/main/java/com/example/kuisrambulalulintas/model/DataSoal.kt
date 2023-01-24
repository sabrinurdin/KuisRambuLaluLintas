package com.example.kuisrambulalulintas.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataSoal(
    val id_soal : String? = null,
    val image : String? = null,
    val pilihan: ArrayList<String>? = null,
    val jawaban: Int? = null
) : Parcelable
