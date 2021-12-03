package com.example.tprueba.ui.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestEngine {

    companion object {

        fun getRestEngine(): Retrofit {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://gitlab.talana.com/publico/mobile-test-mock-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}