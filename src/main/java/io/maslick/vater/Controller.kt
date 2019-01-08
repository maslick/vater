package io.maslick.vater

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Component
class BeanDefinitions {
    @Bean
    fun getRestClient(): IRestJsonVat {
        return Retrofit.Builder()
            .baseUrl("http://jsonvat.com")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
            .create(IRestJsonVat::class.java)
    }
}

@Service
class VatService(val rest: IRestJsonVat): IService {
    override fun get3Lowest(): List<Country> {
        return rest.getEntry().execute().body()!!.rates
            .sortedBy { it.periods.sortedBy { period -> period.effective_from }[0].rates.standard }
            .take(3)
    }

    override fun get3Highest(): List<Country> {
        return rest.getEntry()
            .execute().body()!!.rates
            .sortedByDescending { it.periods.sortedBy { period -> period.effective_from }[0].rates.standard }
            .take(3)
    }
}