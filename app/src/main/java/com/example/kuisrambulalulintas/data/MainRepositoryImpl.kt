package com.example.kuisrambulalulintas.data

import com.example.kuisrambulalulintas.model.DataSoal
import com.example.kuisrambulalulintas.utils.Resource
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    val db : FirebaseFirestore
) : MainRepository {
    override fun getKuis(resul: (Resource<List<DataSoal>>) -> Unit) {
        db.collection("kuis")
            .get()
            .addOnSuccessListener {
                val datas = arrayListOf<DataSoal>()
                for (document in it){
                    val data = document.toObject(DataSoal::class.java)
                    datas.add(data)
                }

                resul.invoke(
                    Resource.Success(datas)
                )
            }.addOnFailureListener {
                resul.invoke(
                    Resource.Error(
                        it.localizedMessage.toString()
                    )
                )
            }
    }
}