package com.internal.databinding.repository

import android.util.Log
import com.internal.databinding.model.AcronymData
import com.internal.databinding.network.RetrofitClientInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Query

interface AcronymApi {
    @GET("dictionary.py")
    suspend fun getAcronymList(@Query("sf") searchString: String): List<AcronymData?>
}

class AcronymRepository() {
    fun getAcronymList(searchString: String): Flow<List<AcronymData?>?> {
        return flow {
            val acronymList = RetrofitClientInstance().getRetrofitInstance(AcronymApi::class)?.getAcronymList(searchString)
            emit(acronymList)
        }.catch {it ->
            Log.e("Test",it.toString())
            emit(listOf(AcronymData(arrayListOf())))
        }
    }
}

