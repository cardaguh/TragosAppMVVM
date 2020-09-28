package co.cyclopsapps.tragosapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.cyclopsapps.tragosapp.AppDatabase
import co.cyclopsapps.tragosapp.R
import co.cyclopsapps.tragosapp.data.DataSourceImpl
import co.cyclopsapps.tragosapp.data.model.Drink
import co.cyclopsapps.tragosapp.data.model.DrinkEntity
import co.cyclopsapps.tragosapp.domain.RepoImpl
import co.cyclopsapps.tragosapp.ui.viewmodel.MainViewModel
import co.cyclopsapps.tragosapp.ui.viewmodel.VMFactory
import co.cyclopsapps.tragosapp.vo.Resource
import kotlinx.android.synthetic.main.fragment_favoritos.*

class FavoritosFragment : Fragment(), MainAdapter.OnTragoClickListener {

    private val viewModel by viewModels<MainViewModel> { VMFactory(
        RepoImpl(DataSourceImpl(AppDatabase.getDatabase(requireActivity().applicationContext)))
    )  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoritos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.getTragosFavoritos().observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    val lista = result.data.map {
                        Drink(it.tragoId, it.imagen, it.nombre, it.descripcion, it.hasAlcohol)
                    }
                    rv_tragos_favoritos.adapter = MainAdapter(requireContext(), lista, this)
                    //Log.d("LISTA FAVORITOS: ", "${result.data}")
                }
                is Resource.Failure -> {}
            }
        })
    }

    private fun setupRecyclerView() {
        rv_tragos_favoritos.layoutManager = LinearLayoutManager(requireContext())
        rv_tragos_favoritos.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    override fun onTragoClick(drink: Drink, position: Int) {
        //viewModel.deleteDrink(drink)
        //rv_tragos_favoritos.adapter?.notifyItemRemoved(position)
        //rv_tragos_favoritos.adapter?.notifyItemRangeRemoved(position, rv_tragos_favoritos.itemCount!!)
    }

}