package com.internal.databinding.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.reflect.KClass

class RetrofitClientInstance {
    val BASE_URL =  "http://www.nactem.ac.uk/software/acromine/"

    inline fun <reified T : Any> getRetrofitInstance(clazz: KClass<T>): T? {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(T::class.java)
    }
}


