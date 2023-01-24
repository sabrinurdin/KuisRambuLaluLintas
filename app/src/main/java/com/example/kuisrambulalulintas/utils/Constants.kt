package com.example.kuisrambulalulintas.utils

import com.example.kuisrambulalulintas.R
import com.example.kuisrambulalulintas.model.Soal

object Constants {
    val USER_NAME: String = "user_name"
    val TOTAL_SoalS: String = "total_Soals"
    val SCORE: String = "score"

    fun getSoals(): ArrayList<Soal> {
        val SoalsList = ArrayList<Soal>()

        // 1
        val SoalOne = Soal(
            1,
            "Apa arti rambu lalu lintas dari gambar dibawah ini ?",
            R.drawable.camera,
            arrayListOf("Dilarang berhenti", "Dilarang Putar balik", "Dilarang memotret", "Dilarang merokok"),
            2,
        )
        SoalsList.add(SoalOne)

        // 2
        val SoalTwo = Soal(
            2,
            "Apa arti rambu lalu lintas dari gambar dibawah ?",
            R.drawable.delapan,
            arrayListOf("Dilarang berhenti", "Batas Maksimal kecepatan",
                "Dilarang tidur", "Dilarang jalan"),
            1
        )
        SoalsList.add(SoalTwo)

        // 3
        val SoalThree = Soal(
            3,
            "Apa arti rambu lalu lintas dari gambar dibawah ?",
            R.drawable.hatihati,
            arrayListOf("Hati-hati", "Jalanan licin",
                "Dilarang berhenti", "Dilarang parkir"),
            0
        )
        SoalsList.add(SoalThree)

        // 4
        val SoalFour = Soal(
            4,
            "Apa arti rambu lalu lintas dari gambar dibawah ?",
            R.drawable.larangan_motor,
            arrayListOf("Dilarang Kencang", "Jalan licin",
                "Dilaran Lewat Kendaraaan", "Dilarang berhenti"),
            2
        )
        SoalsList.add(SoalFour)

        // 5
        val SoalFive = Soal(
            5,
            "Apa arti rambu lalu lintas dari gambar dibawah ?",
            R.drawable.larangan_parkir,
            arrayListOf("Dilarang Kencang", "Jalan licin",
                "Dilaran Lewat Kendaraaan", "Dilarang Parkir"),
            3
        )
        SoalsList.add(SoalFive)

        // 6
        val SoalSix = Soal(
            6,
            "Apa arti rambu lalu lintas dari gambar dibawah ?",
            R.drawable.licin,
            arrayListOf("Dilarang Kencang", "Jalan licin",
                "Dilaran Lewat Kendaraaan", "Dilarang berhenti"),
            1
        )

        SoalsList.add(SoalSix)

        // 7
        val SoalSeven = Soal(
            7,
            "Apa arti rambu lalu lintas dari gambar dibawah ?",
            R.drawable.merokok,
            arrayListOf("Dilarang Merokok", "Jalan licin",
                "Dilaran Lewat Kendaraaan", "Dilarang berhenti"),
            0
        )
        SoalsList.add(SoalSeven)

        // 8
        val SoalEight = Soal(
            8,
            "Apa arti rambu lalu lintas dari gambar dibawah ?",
            R.drawable.motor,
            arrayListOf("Dilarang Kencang", "Jalanan licin",
                "Dilarang motor", "Dilarang berhenti"),
            2
        )
        SoalsList.add(SoalEight)

        // 9
        val SoalNine = Soal(
            9,
            "Apa arti rambu lalu lintas dari gambar dibawah ?",
            R.drawable.pejalan,
            arrayListOf("Dilarang Kencang", "Jalanan licin",
                "Dilarang motor", "Dilarang Jalan kaki"),
            3
        )
        SoalsList.add(SoalNine)

        // 10
        val SoalTen = Soal(
            10,
            "Apa arti rambu lalu lintas dari gambar dibawah ?",
            R.drawable.putarbalik,
            arrayListOf("Dilarang Kencang", "Dilarang Putar ke Kiri",
                "Dilarang motor", "Dilarang berhenti"),
            1
        )
        SoalsList.add(SoalTen)

        return SoalsList
    }
}