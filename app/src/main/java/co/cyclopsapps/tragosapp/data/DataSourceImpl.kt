package co.cyclopsapps.tragosapp.data

import co.cyclopsapps.tragosapp.AppDatabase
import co.cyclopsapps.tragosapp.data.model.Drink
import co.cyclopsapps.tragosapp.data.model.DrinkEntity
import co.cyclopsapps.tragosapp.domain.DataSource
import co.cyclopsapps.tragosapp.vo.Resource
import co.cyclopsapps.tragosapp.vo.RetrofitClient

/**
 * Created by Carlos Daniel Agudelo on 27/09/2020.
 */
class DataSourceImpl(private val appDatabase: AppDatabase): DataSource {

    override suspend fun getTragoByName(tragoName: String): Resource<List<Drink>> {
        return Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinkList)
    }

    override suspend fun insertTragoIntoRoom(trago: DrinkEntity) {
        appDatabase.tragoDao().insertFavorite(trago)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDatabase.tragoDao().getAllFavoriteDrinks())
    }

    override suspend fun deleteDrink(drink: DrinkEntity) {
        appDatabase.tragoDao().deleteDrink(drink)
    }

    /*val generateTragosList = Resource.Success(listOf<Drink>(
        Drink("https://cdn5.recetasdeescandalo.com/wp-content/uploads/2018/09/Coctel-margarita-como-prepararlo.-Receta-e-ingredientes.jpg", nombre = "Margarita", descripcion = "con azucar y vodka y nueces"),
        Drink("https://www.recetas-argentinas.com/base/stock/Recipe/2-image/2-image_web.jpg", nombre = "Fernet", descripcion = "Fernet con coca y hielo"),
        Drink("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTwntZ2fOUDxNaE3HtjxEOEdctkVmQzmbAsXw&usqp=CAU", nombre = "Toro", descripcion = "Toro con pritty"),
        Drink("https://64.media.tumblr.com/2a00c67fe2becf9e6704245c2432e625/tumblr_ny82d7tHAT1u916tro1_640.jpg", nombre = "Gancia", descripcion = "Gancia con Sprite")
    ))*/

    /*fun getTragosList(): Resource<List<Drink>> {
        return Resource.Success(generateTragosList)
    }*/


}