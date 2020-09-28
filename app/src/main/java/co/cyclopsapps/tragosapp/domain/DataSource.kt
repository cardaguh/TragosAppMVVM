package co.cyclopsapps.tragosapp.domain

import co.cyclopsapps.tragosapp.data.model.Drink
import co.cyclopsapps.tragosapp.data.model.DrinkEntity
import co.cyclopsapps.tragosapp.vo.Resource
import co.cyclopsapps.tragosapp.vo.RetrofitClient

/**
 * Created by Carlos Daniel Agudelo on 28/09/2020.
 */
interface DataSource {
    suspend fun getTragoByName(tragoName: String): Resource<List<Drink>>
    suspend fun insertTragoIntoRoom(trago: DrinkEntity)
    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>>
    suspend fun deleteDrink(drink: DrinkEntity)
}