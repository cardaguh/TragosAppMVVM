package co.cyclopsapps.tragosapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import co.cyclopsapps.tragosapp.AppDatabase
import co.cyclopsapps.tragosapp.R
import co.cyclopsapps.tragosapp.data.DataSourceImpl
import co.cyclopsapps.tragosapp.data.model.Drink
import co.cyclopsapps.tragosapp.data.model.DrinkEntity
import co.cyclopsapps.tragosapp.domain.RepoImpl
import co.cyclopsapps.tragosapp.ui.viewmodel.MainViewModel
import co.cyclopsapps.tragosapp.ui.viewmodel.VMFactory
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_tragos_detalle.*

class TragosDetalleFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel> { VMFactory(
        RepoImpl(DataSourceImpl(AppDatabase.getDatabase(requireActivity().applicationContext)))) }

    private lateinit var drink: Drink

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable("drink")!!
            //Log.d("DETALLES_FRAG", "$drink")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tragos_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(drink.imagen).into(img_trago)
        trago_title.text = drink.nombre
        trago_desc.text = drink.descripcion
        if (drink.hasAlcohol == "Non_Alcoholic") {
            txt_has_alcohol.text = "Bebida sin alcohol"
        } else {
            txt_has_alcohol.text = "Bebida con alcohol"
        }

        btn_guardar_trago.setOnClickListener {
            viewModel.guardarTrago(DrinkEntity(drink.tragoId, drink.imagen, drink.nombre, drink.descripcion, drink.hasAlcohol))
            Toast.makeText(requireContext(), "Se guardó el trago a favoritos", Toast.LENGTH_SHORT).show()
        }
    }
}