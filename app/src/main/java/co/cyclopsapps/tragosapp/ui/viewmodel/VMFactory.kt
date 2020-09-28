package co.cyclopsapps.tragosapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.cyclopsapps.tragosapp.domain.Repo

/**
 * Created by Carlos Daniel Agudelo on 27/09/2020.
 */
class VMFactory(private val repo: Repo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }
}