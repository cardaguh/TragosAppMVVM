package co.cyclopsapps.tragosapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.cyclopsapps.tragosapp.data.model.DrinkEntity
import co.cyclopsapps.tragosapp.domain.TragosDao

/**
 * Created by Carlos Daniel Agudelo on 27/09/2020.
 */
@Database(entities = arrayOf(DrinkEntity::class), version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun tragoDao(): TragosDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            INSTANCE = INSTANCE ?: Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "tabla_tragos").build()
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}