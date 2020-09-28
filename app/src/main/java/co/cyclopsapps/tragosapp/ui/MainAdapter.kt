package co.cyclopsapps.tragosapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.tragosapp.R
import co.cyclopsapps.tragosapp.base.BaseViewHolder
import co.cyclopsapps.tragosapp.data.model.Drink
import co.cyclopsapps.tragosapp.data.model.DrinkEntity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.tragos_row.view.*

/**
 * Created by Carlos Daniel Agudelo on 27/09/2020.
 */

class MainAdapter(
    private val context: Context, private val tragosList: List<Drink>,
    private val itemClickListener: OnTragoClickListener
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnTragoClickListener {
        fun onTragoClick(drink: Drink, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.tragos_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return tragosList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(tragosList[position], position)
        }
    }

    inner class MainViewHolder(itemView: View) : BaseViewHolder<Drink>(itemView) {
        override fun bind(item: Drink, position: Int) {
            Glide.with(context).load(item.imagen).centerCrop().into(itemView.img_trago)
            itemView.txt_titulo.text = item.nombre
            itemView.txt_descripcion.text = item.descripcion
            itemView.setOnClickListener { itemClickListener.onTragoClick(item, position) }
        }
    }
}