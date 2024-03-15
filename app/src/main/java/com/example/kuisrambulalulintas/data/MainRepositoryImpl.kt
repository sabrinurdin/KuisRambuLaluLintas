package com.example.kuisrambulalulintas.data

import com.example.kuisrambulalulintas.data.local.KuisDao
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import com.example.kuisrambulalulintas.model.DataSoal
import com.example.kuisrambulalulintas.utils.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    val db : FirebaseFirestore,
    val database : KuisDao
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

    override suspend fun addHistory(name: String, score: Int) {
        return withContext(Dispatchers.IO){
            database.insert(
                HistoryEntity(0,name, score)
            )
        }
    }

    override suspend fun getAllHistory(): Flow<List<HistoryEntity>> {
        return withContext(Dispatchers.IO){
            database.getAllHistoryKuis()
        }
    }
}