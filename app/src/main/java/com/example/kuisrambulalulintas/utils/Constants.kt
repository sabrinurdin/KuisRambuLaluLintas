package com.example.kuisrambulalulintas.utils

import com.example.kuisrambulalulintas.R
import com.example.kuisrambulalulintas.model.Gambar
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

    fun getRambuLarangan() : ArrayList<Gambar>{
        val gambarList = ArrayList<Gambar>()

        val g1 = Gambar(1,"Dilarang Parkir",R.drawable.larangan_parkir)
        gambarList.add(g1)
        val g2 = Gambar(2,"Hati-hati",R.drawable.hatihati)
        gambarList.add(g2)
        val g3 = Gambar(3,"Jalanan licin",R.drawable.licin)
        gambarList.add(g3)
        val g4 = Gambar(4,"Dilarang Belok Kiri",R.drawable.putarbalik)
        gambarList.add(g4)
        val g5 = Gambar(5,"DilarangMerokok",R.drawable.merokok)
        gambarList.add(g5)
        val g6 = Gambar(6,"Dilarang berjalan terus, wajib berhenti sesaat dan meneruskan perjalanan setelah mendapat kepastian aman dari lalu lintas arah lainnya.",R.drawable.larangan6_berjalan_terus)
        gambarList.add(g6)
        val g7 = Gambar(7,"Kendaraan dengan muatan sumbu terberat (MST) lebih besar dari 8 ton atau ukuran lebar tidak melebihi 2.500 milimeter atau ukuran panjang tidak melebihi 12.000 milimeter.",R.drawable.larangan7_muatan_terberat)
        gambarList.add(g7)
        val g8 = Gambar(8,"Dilarang berjalan terus apabila mengakibatkan rintangan, hambatan, gangguan bagi lalulintas dari arah lain yang wajib didahulukan.",R.drawable.larangan8_berjalan_terus)
        gambarList.add(g8)
        val g9 = Gambar(9,"Dilarang berjalan seruas, wajib berhenti sesaat sebelum bagian jalan tertentu dan meneruskan perjalanan setelah mendahulukan kendaraan yang datang dari arah depan secara bersamaan.",R.drawable.larangan9_berjalan_seruas)
        gambarList.add(g9)
        val g10 = Gambar(10,"Batas akhir larangan mendahului kendaraan lain.",R.drawable.larangan10_batasakhir)
        gambarList.add(g10)
        val g11 = Gambar(11,"Larangan berbalik arah bagi kendaraan bermotor maupun tidak bermotor.",R.drawable.larangan11_berbalik_arah)
        gambarList.add(g11)
        val g12 = Gambar(12,"Larangan berbelok ke kiri bagi kendaraan bermotor maupun tidak bermotor untuk masuk jalan simpangan atau berpindah jalur yang searah lalulintas.",R.drawable.larangan12_belok_kiri)
        gambarList.add(g12)
        val g13 = Gambar(13,"Larangan berhenti sampai jarak 15 m dari tempat pemasangan rambu menurut arah lalulintas kecuali dinyatakan lain dengan papan tambahan.",R.drawable.larangan13_berhenti15)
        gambarList.add(g13)
        val g14 = Gambar(14,"Larangan berbelok ke kanan bagi kendaraan bermotor maupun tidak bermotor untuk masuk jalan simpangan atau berpindah jalur yang searah lalulintas.",R.drawable.larangan14_belok_kanan)
        gambarList.add(g14)
        val g15 = Gambar(15,"Larangan kecepatan kendaraan lebih dari 40 km perjam (Rambu Larangan).",R.drawable.larangan15_kecepatan40)
        gambarList.add(g15)
        val g16 = Gambar(16,"Larangan masuk bagi becak.",R.drawable.larangan16_becak)
        gambarList.add(g16)
        val g17 = Gambar(17,"Larangan masuk bagi bus.",R.drawable.larangan17_bus)
        gambarList.add(g17)
        val g18 = Gambar(18,"Larangan masuk bagi delman dan sejenisnya.",R.drawable.larangan18_delman)
        gambarList.add(g18)
        val g19 = Gambar(19,"Larangan masuk bagi gerobak dan dokar.",R.drawable.larangan19_gerobak)
        gambarList.add(g19)
        val g20 = Gambar(20,"Larangan masuk bagi gerobak dorong dan sejenisnya.",R.drawable.larangan20_gerobak_dorong)
        gambarList.add(g20)
        val g21 = Gambar(21,"Larangan masuk bagi gerobak pedati dan sejenisnya (Rambu Larangan).",R.drawable.larangan21_batasakhir2)
        gambarList.add(g21)
        val g22 = Gambar(22,"Larangan masuk bagi kendaraan bermotor dan mobil.",R.drawable.larangan22_mobil_motor)
        gambarList.add(g22)
        val g23 = Gambar(23,"Larangan masuk bagi kendaraan bermotor dengan kereta gandeng.",R.drawable.larangan23_motor_kereta_gandeng)
        gambarList.add(g23)
        val g24 = Gambar(24,"Larangan masuk bagi kendaraan bermotor dengan kereta tempel.",R.drawable.larangan24_kereta_tempel)
        gambarList.add(g24)
        val g25 = Gambar(25,"Larangan masuk bagi kendaraan bermotor roda empat atau lebih.",R.drawable.larangan25_kendaraan_roda_empat)
        gambarList.add(g25)
        val g26 = Gambar(26,"Larangan masuk bagi kendaraan bermotor roda tiga.",R.drawable.larangan26_rodatiga)
        gambarList.add(g26)
        val g27 = Gambar(27,"Larangan masuk bagi kendaraan yang seluruh berat termasuk muatannya lebih dari 7 ton.",R.drawable.larangan27_7ton)
        gambarList.add(g27)
        val g28 = Gambar(28,"Larangan masuk bagi mobil barang.",R.drawable.larangan28_mobil_barang)
        gambarList.add(g28)
        val g29 = Gambar(29,"Larangan masuk bagi pejalan kaki.",R.drawable.larangan29_pejalan_kaki)
        gambarList.add(g29)
        val g30 = Gambar(30,"Batas kecepatan maksimum 40 km jam.",R.drawable.larangan30_batas_kecepatan)
        gambarList.add(g30)
        val g31 = Gambar(31,"Larangan masuk bagi semua kendaraan bermotor maupun tidak bermotor dari kedua arah.",R.drawable.larangan31_semuakendaraan_semuarah)
        gambarList.add(g31)
        val g32 = Gambar(32,"Larangan masuk bagi semua kendaraan tidak bermotor.",R.drawable.larangan32_semua_tidak_bermotor)
        gambarList.add(g32)
        val g33 = Gambar(33,"Larangan masuk bagi sepeda.",R.drawable.larangan33_sepeda)
        gambarList.add(g33)
        val g34 = Gambar(34,"Larangan masuk bagi kendaraan dengan lebar lebih dari 2,7 m.",R.drawable.larangan34_lebar27m)
        gambarList.add(g34)
        val g35 = Gambar(35,"Larangan masuk bagi kendaraan dengan muatan sumbu dari 8 ton.",R.drawable.larangan35_8ton)
        gambarList.add(g35)
        val g36 = Gambar(36,"Larangan masuk bagi kendaraan dengan muatan sumbu terberat (MST) lebih besar dari 10 ton atau ukuran lebar tidak melebihi 2.500 milimeter atau ukuran panjang tidak melebihi 18.000 milimeter.",R.drawable.larangan36_10ton)
        gambarList.add(g36)
        val g37 = Gambar(37,"Larangan masuk bagi kendaraan dengan muatan sumbu terberat (MTS) lebih besar dari 8 ton atau ukuran lebar tidak melebihi 2.500 milimeter atau ukuran panjang tidak melebihi 18.000 milimeter.",R.drawable.larangan37_3a)
        gambarList.add(g37)
        val g38 = Gambar(38,"Larangan masuk bagi kendaraan dengan tinggi lebih dari 4,5 m.",R.drawable.larangan38_45meter)
        gambarList.add(g38)
        val g39 = Gambar(39,"Larangan masuk bagi kendaraan tidak bermotor dengan panjang lebih dari … m.",R.drawable.larangan39_panjang)
        gambarList.add(g39)
        val g40 = Gambar(40,"Larangan masuk bagi sepeda dan becak.",R.drawable.larangan40_becak_sepeda)
        gambarList.add(g40)
        val g41 = Gambar(41,"Larangan mendahului kendaraan lain yang berjalan didepan.",R.drawable.larangan41_mendahului)
        gambarList.add(g41)
        val g42 = Gambar(42,"Larangan menggunakan isyarat suara",R.drawable.larangan42_suara)
        gambarList.add(g42)
        val g43 = Gambar(43,"Sumbu terberat (MST) lebih besar dari 8 ton atau ukuran lebar tidak melebihi 2.100 milimeter atau ukuran panjang tidak melebihi 9.000 milimeter",R.drawable.larangan43_9000milimeter)
        gambarList.add(g43)
        val g44 = Gambar(44,"Larangan masuk bagi gerobak pedati dan sejenisnya (Rambu Larangan)",R.drawable.larangan44_gerobak_pedati)
        gambarList.add(g44)
        val g45 = Gambar(45,"Larangan masuk bagi semua kendaraan bermotor maupun tidak bermotor (Rambu Larangan).",R.drawable.larangan45_semua_kendaraan)
        gambarList.add(g45)

        return gambarList
    }

    fun getRambuPeringatan() : ArrayList<Gambar>{
        val gambarList = ArrayList<Gambar>()

        val g1 = Gambar(1,"angin dari samping",R.drawable.peringatan1_angin_dari_samping)
        gambarList.add(g1)
        val g2 = Gambar(2,"area banyak pejalan kaki (Rambu Peringatan)",R.drawable.peringatan2_banyak_pejalan)
        gambarList.add(g2)
        val g3 = Gambar(3,"banyak anak-anak",R.drawable.peringatan3_banyak_anak)
        gambarList.add(g3)
        val g4 = Gambar(4,"banyak satwa jinak dan sering menyebrang",R.drawable.peringatan4_satwa_jinak)
        gambarList.add(g4)
        val g5 = Gambar(5,"banyak satwa liar dan sering menyebrang",R.drawable.peringatan5_satwa_liar)
        gambarList.add(g5)
        val g6 = Gambar(6,"banyak tikungan.",R.drawable.peringatan6_banyak_tikungan)
        gambarList.add(g6)
        val g7 = Gambar(7,"bundaran.",R.drawable.peringatan7_bundaran)
        gambarList.add(g7)
        val g8 = Gambar(8,"hati-hati.",R.drawable.peringatan8_hatihati)
        gambarList.add(g8)
        val g9 = Gambar(9,"jalan bergelombang.",R.drawable.peringatan9_jalan_bergelombang)
        gambarList.add(g9)
        val g10 = Gambar(10,"jalan cekung.",R.drawable.peringatan10_jalan_cekumg)
        gambarList.add(g10)
        val g11 = Gambar(11,"jalan cembung.",R.drawable.peringatan_jalan_cembung)
        gambarList.add(g11)
        val g12 = Gambar(12,"jalan licin",R.drawable.peringatan12_jalan_licin)
        gambarList.add(g12)
        val g13 = Gambar(13,"jembatan.",R.drawable.peringatan13_jembatan)
        gambarList.add(g13)
        val g14 = Gambar(14,"jembatan angkat.",R.drawable.peringatan14_angkat)
        gambarList.add(g14)
        val g15 = Gambar(15,"kerikil lepas.",R.drawable.peringatan15_kericil_lepas)
        gambarList.add(g15)
        val g16 = Gambar(16,"lalu lintas dua arah",R.drawable.peringatan15_laluluntas_dua_arah)
        gambarList.add(g16)
        val g17 = Gambar(17,"lampu lalu lintas.",R.drawable.peringatan17_lalulintas)
        gambarList.add(g17)
        val g18 = Gambar(18,"lebar ruang bebas (Rambu Peringatan).",R.drawable.peringatan18_ruang_bebas)
        gambarList.add(g18)
        val g19 = Gambar(19,"lintasan pesawat terbang.",R.drawable.peringatan19_lintasan_pesawat)
        gambarList.add(g19)
        val g20 = Gambar(20,"longsoran tanah.",R.drawable.peringatan20_longsoran_tanah)
        gambarList.add(g20)
        val g21 = Gambar(21,"pekerjaan jalan.",R.drawable.peringatan21_pekerjaan_jalan)
        gambarList.add(g21)
        val g22 = Gambar(22,"pendakian.",R.drawable.peringatan22_pendakian)
        gambarList.add(g22)
        val g23 = Gambar(23,"pendakian curam.",R.drawable.peringatan23_pendakian_curam)
        gambarList.add(g23)
        val g24 = Gambar(24,"pengarah tikungan ke kiri dan ke kanan.",R.drawable.peringatan24_pengarah_kirikanan)
        gambarList.add(g24)
        val g25 = Gambar(25,"penyebrangan pejalan kaki.",R.drawable.peringatan25_penyebrangan_pejalankaki)
        gambarList.add(g25)
        val g26 = Gambar(26,"penyempitan jalan di kiri dan kanan.",R.drawable.peringatan26_penyempitan_kirikanan)
        gambarList.add(g26)
        val g27 = Gambar(27,"penyempitan jalan sebelah kanan.",R.drawable.peringatan26_penyempitan_kanan)
        gambarList.add(g27)
        val g28 = Gambar(28,"penyempitan jalan sebelah kiri (Rambu Peringatan).",R.drawable.peringatan28_penyimpatan_kiri)
        gambarList.add(g28)
        val g29 = Gambar(29,"perisimpangan tiga sisi kanan.",R.drawable.peringatan29_persimpangantiga_kanan)
        gambarList.add(g29)
        val g30 = Gambar(30,"persilangan datar dengan lintasan kereta api berpintu.",R.drawable.peringatan30_persilangan_datar_berpintu)
        gambarList.add(g30)
        val g31 = Gambar(31,"persilangan datar dengan lintasan kereta api tanpa pintu.",R.drawable.peringatan31_persilangan_datar_tanpa_pintu)
        gambarList.add(g31)
        val g32 = Gambar(32,"persimpangan empat.",R.drawable.peringatan32_persimpangan_empat)
        gambarList.add(g32)
        val g33 = Gambar(33,"persimpangan ganda kiri kanan.",R.drawable.peringatan33_persimpangan_ganda_kirikanan)
        gambarList.add(g33)
        val g34 = Gambar(34,"persimpangan tiga serong ke kanan.",R.drawable.peringatan34_persimpangantiga_serong_kanan)
        gambarList.add(g34)
        val g35 = Gambar(35,"persimpangan tiga serong ke kiri.",R.drawable.peringatan35_persimpangantiga_serong_kiri)
        gambarList.add(g35)
        val g36 = Gambar(36,"persimpangan tiga sisi kiri.",R.drawable.peringatan36_persimpangantiga_kiri)
        gambarList.add(g36)
        val g37 = Gambar(37,"persimpangan tiga type T.",R.drawable.peringatan37_persimpangantiga_typet)
        gambarList.add(g37)
        val g38 = Gambar(38,"persimpangan tiga type Y.",R.drawable.peringatan38_persimpangantiga_typey)
        gambarList.add(g38)
        val g39 = Gambar(39,"tikungan ganda tikungan pertama ke kanan.",R.drawable.peringatan39_tikungan_ganda_kanan)
        gambarList.add(g39)
        val g40 = Gambar(40,"tikungan ganda tikungan pertama ke kiri.",R.drawable.peringatan40_tikungan_ganda_kiri)
        gambarList.add(g40)
        val g41 = Gambar(41,"tikungan ke kanan.",R.drawable.peringatan41_tikungan_kekanan)
        gambarList.add(g41)
        val g42 = Gambar(42,"tikungan ke kiri",R.drawable.peringatan42_tikungan_kekiri)
        gambarList.add(g42)
        val g43 = Gambar(43,"tikungan tajam ke kanan",R.drawable.peringatan43_tikungan_tajam_kanan)
        gambarList.add(g43)
        val g44 = Gambar(44,"tinggi ruang bebas",R.drawable.peringatan45_tinggi_ruang_bebas)
        gambarList.add(g44)
        val g45 = Gambar(45,"turunan .",R.drawable.peringatan45_turunan)
        gambarList.add(g45)
        val g46 = Gambar(46,"turunan terjal  .",R.drawable.peringatan46_turunan_terjal)
        gambarList.add(g46)

        return gambarList
    }

    fun getRambuPerintah() : ArrayList<Gambar>{
        val gambarList = ArrayList<Gambar>()

        val g1 = Gambar(1,"Batas akhir kecepatan minimum yang diwajibkan",R.drawable.perintah1_batas_akhir_kecepatan)
        gambarList.add(g1)
        val g2 = Gambar(2,"Batas akhir wajib memakai rantai pada ban",R.drawable.perintah2_batas_memakai_rantai)
        gambarList.add(g2)
        val g3 = Gambar(3,"jalan satu arah ke kanan",R.drawable.perintah3_jalan_satuh_arah_kanan)
        gambarList.add(g3)
        val g4 = Gambar(4,"Lajur atau bagian jalan yang wajib dilewati",R.drawable.perintah4_jalur_wajib_dilewati)
        gambarList.add(g4)
        val g5 = Gambar(5,"Perintah kecepatan minumum yang diwajibkan",R.drawable.perintah5_kecepatan_minimun)
        gambarList.add(g5)
        val g6 = Gambar(6,"Wajib berjalan lurus kedepan.",R.drawable.perintah6_wajib_berjalan_lurus)
        gambarList.add(g6)
        val g7 = Gambar(7,"Wajib melewati salah satu lajur yang ditunjuk.",R.drawable.perintah7_wajib_melewati_salasatu_jalur)
        gambarList.add(g7)
        val g8 = Gambar(8,"Wajib memakai rantai pada ban.",R.drawable.perintah8_wajib_memakai_ban_rantai)
        gambarList.add(g8)
        val g9 = Gambar(9,"Wajib Mengikuti Arah Ke Kanan.",R.drawable.perintah9_wajib_jalur_kanan)
        gambarList.add(g9)
        val g10 = Gambar(10,"Wajib Mengikuti Arah Ke Kiri.",R.drawable.perintah10_wajib_jalur_kiri)
        gambarList.add(g10)
        val g11 = Gambar(11,"Wajib mengikuti arah yang ditunjuk.",R.drawable.perintah11_wajib_jalur_ditunjuk)
        gambarList.add(g11)
        val g12 = Gambar(12,"Wajib mengikuti salah satu arah yang ditunjuk.",R.drawable.perintah12_wajub_mengikuti_salahsatu_jalur)
        gambarList.add(g12)
        val g13 = Gambar(13,"Wajib mengikuti salah satu arah yang ditunjuki.",R.drawable.perintah13_wajub_mengikuti_salahsatu_jalur)
        gambarList.add(g13)
        val g14 = Gambar(14,"Wajib untuk lalu lintas pedati.",R.drawable.perintah14_wajib_pedati)
        gambarList.add(g14)
        val g15 = Gambar(15,"Wajib untuk lalulintas becak.",R.drawable.perintah15_wajib_becak)
        gambarList.add(g15)
        val g16 = Gambar(16,"lWajib untuk lalulintas bersepeda",R.drawable.perintah16_wajib_sepeda)
        gambarList.add(g16)
        val g17 = Gambar(17,"Wajib untuk lalulintas dokar.",R.drawable.perintah17_wajib_dokar)
        gambarList.add(g17)
        val g18 = Gambar(18,"Wajib untuk lalulintas pedati, gerobak dorong dan dokar.",R.drawable.perintah18_wajib_gerobak)
        gambarList.add(g18)
        val g19 = Gambar(19,"Wajib untuk lalulintas pengendara berkuda.",R.drawable.perintah19_wajib_berkuda)
        gambarList.add(g19)
        val g20 = Gambar(20,"Wajib untuk pejalan kaki.",R.drawable.perintah20_wajib_pejalan)
        gambarList.add(g20)

        return gambarList
    }

    fun getRambuLPetunjuk() : ArrayList<Gambar>{
        val gambarList = ArrayList<Gambar>()

        val g1 = Gambar(1,"akhir dari jalan tol",R.drawable.petunjuk1_akhir_jalan_tol)
        gambarList.add(g1)
        val g2 = Gambar(2,"bandara udara",R.drawable.petunjuk2_bandara)
        gambarList.add(g2)
        val g3 = Gambar(3,"bengkel",R.drawable.petunjuk3_bengkel)
        gambarList.add(g3)
        val g4 = Gambar(4,"gelanggang olahraga",R.drawable.petunjuk4_olahraga)
        gambarList.add(g4)
        val g5 = Gambar(5,"gereja",R.drawable.petunjuk5_gereja)
        gambarList.add(g5)
        val g6 = Gambar(6,"halte bus.",R.drawable.petunjuk6_halte_bus)
        gambarList.add(g6)
        val g7 = Gambar(7,"jalan buntu",R.drawable.petunjuk7_jalan_buntu)
        gambarList.add(g7)
        val g8 = Gambar(8,"jalan satu arah ke kiri",R.drawable.petunjuk8_jalan_satu_arah_kiri)
        gambarList.add(g8)
        val g9 = Gambar(9,"jalan satu arah lurus",R.drawable.petunjuk9_jalur_satu_arah_lurus)
        gambarList.add(g9)
        val g10 = Gambar(10,"jalan tol",R.drawable.petunjuk10_jalan_tol)
        gambarList.add(g10)
        val g11 = Gambar(11,"jembatan timbang",R.drawable.petunjuk11_jembatan_timbang)
        gambarList.add(g11)
        val g12 = Gambar(12,"kamp pengunsian",R.drawable.petunjuk12_kamp_pengungsian)
        gambarList.add(g12)
        val g13 = Gambar(13,"kantor pos",R.drawable.petunjuk13_kantor_pos)
        gambarList.add(g13)
        val g14 = Gambar(14,"kemah karvan",R.drawable.petunjuk14_kemah_karvan)
        gambarList.add(g14)
        val g15 = Gambar(15,"kemah tenda",R.drawable.petunjuk15_kemah_tenda)
        gambarList.add(g15)
        val g16 = Gambar(16,"lkendaraan umum selain bus dan taksi",R.drawable.petunjuk16_kendaraan_umum_selain_taksi)
        gambarList.add(g16)
        val g17 = Gambar(17,"khusus kendaraan bermotor",R.drawable.petunjuk17_kendaraan_bermotor)
        gambarList.add(g17)
        val g18 = Gambar(18,"kolam renang",R.drawable.petunjuk18_kolam_renang)
        gambarList.add(g18)
        val g19 = Gambar(19,"lapangan olahraga terbuka",R.drawable.petunjuk19_lapangan_olahraga)
        gambarList.add(g19)
        val g20 = Gambar(20,"lokasi berkumpul darurat",R.drawable.petunjuk20_lokasi_berkumpul_darurat)
        gambarList.add(g20)
        val g21 = Gambar(21,"masjid",R.drawable.petunjuk21_masjid)
        gambarList.add(g21)
        val g22 = Gambar(22,"museum",R.drawable.petunjuk22_museum)
        gambarList.add(g22)
        val g23 = Gambar(23,"pantai",R.drawable.petunjuk23_pantai)
        gambarList.add(g23)
        val g24 = Gambar(24,"Pasar",R.drawable.petunjuk24_pasar)
        gambarList.add(g24)
        val g25 = Gambar(25,"pelabuhan",R.drawable.petunjuk25_pelabuhan)
        gambarList.add(g25)
        val g26 = Gambar(26,"penginapan",R.drawable.petunjuk26_penginapan)
        gambarList.add(g26)
        val g27 = Gambar(27,"perkemahan",R.drawable.petunjuk27_perkemahan)
        gambarList.add(g27)
        val g28 = Gambar(28,"perpustakaan",R.drawable.petunjuk28_perpustakaan)
        gambarList.add(g28)
        val g29 = Gambar(29,"pompa bahan bakar",R.drawable.petunjuk29_pompa_bahan_bakar)
        gambarList.add(g29)
        val g30 = Gambar(30,"Pura",R.drawable.petunjuk30_pura)
        gambarList.add(g30)
        val g31 = Gambar(31,"pusat pengunsian",R.drawable.petunjuk31_pusat_pengungsian)
        gambarList.add(g31)
        val g32 = Gambar(32,"puskesmas",R.drawable.petunjuk32_puskesmas)
        gambarList.add(g32)
        val g33 = Gambar(33,"rumah makan",R.drawable.petunjuk33_rumah_makan)
        gambarList.add(g33)
        val g34 = Gambar(34,"rumah sakit",R.drawable.petunjuk34_rumah_sakit)
        gambarList.add(g34)
        val g35 = Gambar(35,"rute evakuasi gempa bumi",R.drawable.petunjuk35_rute_evakuasi_gempa)
        gambarList.add(g35)
        val g36 = Gambar(36,"rute evakuasi letusan gunung merapi",R.drawable.petunjuk36_letusan_gunung)
        gambarList.add(g36)
        val g37 = Gambar(37,"rute evakuasi stsunami",R.drawable.petunjuk37_tsunami)
        gambarList.add(g37)
        val g38 = Gambar(38,"rute penjelajah alam",R.drawable.petunjuk38_penjelajah_alam)
        gambarList.add(g38)
        val g39 = Gambar(39,"sekolah",R.drawable.petunjuk39_sekolah)
        gambarList.add(g39)
        val g40 = Gambar(40,"stadion",R.drawable.petunjuk40_stadion)
        gambarList.add(g40)
        val g41 = Gambar(41,"stand taksi",R.drawable.petunjuk41_stand_taksi)
        gambarList.add(g41)
        val g42 = Gambar(42,"stasiun kereta api",R.drawable.petunjuk42_stasiun_keretaapi)
        gambarList.add(g42)
        val g43 = Gambar(43,"stasiun uji berkala",R.drawable.petunjuk43_stasiun_uji_berkala)
        gambarList.add(g43)
        val g44 = Gambar(44,"stasiun uji emisi",R.drawable.petunjuk44_uji_emisi)
        gambarList.add(g44)
        val g45 = Gambar(45,"taman",R.drawable.petunjuk45_taman)
        gambarList.add(g45)
        val g46 = Gambar(46,"telpon umum",R.drawable.petunjuk46_telepon_umum)
        gambarList.add(g46)
        val g47 = Gambar(47,"tempat pembuangan akhir",R.drawable.petunjuk47_penuangan_akhir)
        gambarList.add(g47)
        val g48 = Gambar(48,"tempat pembuangan sementara",R.drawable.petunjuk48_pembuangan_sementara)
        gambarList.add(g48)
        val g49 = Gambar(49,"tempat penyebrangan orang",R.drawable.petunjuk49_tempat_penyebrangan)
        gambarList.add(g49)
        val g50 = Gambar(50,"tempat putar balik arah",R.drawable.petunjuk50_putar_balik_arah)
        gambarList.add(g50)
        val g51 = Gambar(51,"terminal bus",R.drawable.petunjuk51_terminal_bus)
        gambarList.add(g51)
        val g52 = Gambar(52,"toko obat",R.drawable.petunjuk52_toko_obat)
        gambarList.add(g52)
        val g53 = Gambar(53,"trowongan berakhir",R.drawable.petunjuk53_terowongan_berakhir)
        gambarList.add(g53)
        val g54 = Gambar(54,"trowongan bermula",R.drawable.petunjuk54_terowongan_bermula)
        gambarList.add(g41)
        val g55 = Gambar(55,"vila",R.drawable.petunjuk55_vila)
        gambarList.add(g55)
        val g56 = Gambar(56,"warung kopi",R.drawable.petunjuk56_warung_kopi)
        gambarList.add(g56)
        val g57 = Gambar(57,"Whara",R.drawable.petunjuk57_whara)
        gambarList.add(g57)
        val g58 = Gambar(58,"Zona Parkir",R.drawable.petunjuk58_zona_patkir)
        gambarList.add(g58)
        val g59 = Gambar(59,"zona parkir untuk penyadangan cacat",R.drawable.petunjuk59_zona_penyandang_cacat)
        gambarList.add(g59)

        return gambarList
    }
}