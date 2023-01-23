package com.example.kuisrambulalulintas

data class Soal(
    val id: Int,
    val teks_Soal:String,
    val gambar: Int,
    val alternative: ArrayList<String>,
    val jawabanBenarIndex: Int
)
