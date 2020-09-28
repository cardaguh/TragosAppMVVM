package co.cyclopsapps.tragosapp.base

import android.view.View
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Carlos Daniel Agudelo on 27/09/2020.
 */

abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T, position: Int)
}