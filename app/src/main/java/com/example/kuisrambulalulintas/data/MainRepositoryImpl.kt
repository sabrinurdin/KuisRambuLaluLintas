package com.example.kuisrambulalulintas.data

import com.example.kuisrambulalulintas.data.local.KuisDao
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity2
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity3
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity4
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity5
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

    override suspend fun addHistory2(name: String, score: Int) {
        return withContext(Dispatchers.IO){
            database.insert2(
                HistoryEntity2(0,name, score)
            )
        }
    }

    override suspend fun addHistory3(name: String, score: Int) {
        return withContext(Dispatchers.IO){
            database.insert3(
                HistoryEntity3(0,name, score)
            )
        }
    }

    override suspend fun addHistory4(name: String, score: Int) {
        return withContext(Dispatchers.IO){
            database.insert4(
                HistoryEntity4(0,name, score)
            )
        }
    }

    override suspend fun addHistory5(name: String, score: Int) {
        return withContext(Dispatchers.IO){
            database.insert5(
                HistoryEntity5(0,name, score)
            )
        }
    }

    override suspend fun getAllHistory(): Flow<List<HistoryEntity>> {
        return withContext(Dispatchers.IO){
            database.getAllHistoryKuis()
        }
    }

    override suspend fun getAllHistory2(): Flow<List<HistoryEntity2>> {
        return withContext(Dispatchers.IO){
            database.getAllHistoryKuis2()
        }
    }

    override suspend fun getAllHistory3(): Flow<List<HistoryEntity3>> {
        return withContext(Dispatchers.IO){
            database.getAllHistoryKuis3()
        }
    }

    override suspend fun getAllHistory4(): Flow<List<HistoryEntity4>> {
        return withContext(Dispatchers.IO){
            database.getAllHistoryKuis4()
        }
    }

    override suspend fun getAllHistory5(): Flow<List<HistoryEntity5>> {
        return withContext(Dispatchers.IO){
            database.getAllHistoryKuis5()
        }
    }
}