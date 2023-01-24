package com.example.kuisrambulalulintas.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pilihan(
    val pilihan_A : String? = null,
    val pilihan_B : String? = null,
    val pilihan_C : String? = null,
    val pilihan_D : String? = null,
    val jawaban : Int? = null,
) : Parcelable
