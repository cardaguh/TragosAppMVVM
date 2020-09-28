package co.cyclopsapps.tragosapp.domain

import co.cyclopsapps.tragosapp.data.model.Drink
import co.cyclopsapps.tragosapp.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Carlos Daniel Agudelo on 27/09/2020.
 */
interface WebService {

    @GET("search.php")
    suspend fun getTragoByName(@Query(value = "s") tragoName: String): DrinkList
}