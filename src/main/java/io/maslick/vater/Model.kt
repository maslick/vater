package io.maslick.vater

import retrofit2.Call
import retrofit2.http.GET

data class Entry(val rates: List<Country>)
data class Country(val name: String, val code: String, val periods: List<Period>)
data class Period(val effective_from: String, val rates: Rate)
data class Rate(val reduced: Double, val standard: Double)


interface IService {
    fun get3Lowest(): List<Country>
    fun get3Highest(): List<Country>
}

interface IRestJsonVat {
    @GET("/") fun getEntry(): Call<Entry>
}