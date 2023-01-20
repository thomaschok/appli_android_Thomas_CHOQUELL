package fr.isen.choquell.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class CustomAdapter(
    private var itemsList: ArrayList<String>,
    val onItemClickListener: () -> Unit
) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {


    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.itemtextview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextView.text = item
        holder.itemTextView.setOnClickListener {
            onItemClickListener()
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    fun refreshList(mealFromAPI: ArrayList<String>) {
        itemsList = mealFromAPI
        notifyDataSetChanged()
    }
}




