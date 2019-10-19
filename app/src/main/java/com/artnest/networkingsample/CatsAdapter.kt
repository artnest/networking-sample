package com.artnest.networkingsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.artnest.networkingsample.data.response.CatResponse

class CatsAdapter : RecyclerView.Adapter<CatsAdapter.CatViewHolder>() {

    private val cats: MutableList<CatResponse> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(cats[position])
    }

    override fun getItemCount() = cats.size

    fun submitList(newCats: List<CatResponse>) {
        cats += newCats
        notifyDataSetChanged() // used here for simplicity, you must never use it
    }

    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image: ImageView = itemView.findViewById(R.id.image_cat)

        fun bind(cat: CatResponse) {
            image.load(cat.url)
        }
    }
}