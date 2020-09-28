package co.cyclopsapps.tragosapp.domain

import co.cyclopsapps.tragosapp.data.model.Drink
import co.cyclopsapps.tragosapp.data.model.DrinkEntity
import co.cyclopsapps.tragosapp.vo.Resource

/**
 * Created by Carlos Daniel Agudelo on 27/09/2020.
 */
interface Repo {

    suspend fun getTragosList(tragoName: String): Resource<List<Drink>>
    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>>
    suspend fun insertTrago(trago: DrinkEntity)
    suspend fun deleteDrink(drink: DrinkEntity)
}