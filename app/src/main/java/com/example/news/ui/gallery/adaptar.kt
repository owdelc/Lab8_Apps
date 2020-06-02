package com.example.news.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news.R
import com.example.news.network.Resultado

class adaptar(val result: List<Resultado>): RecyclerView.Adapter<NViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.formato, parent, false)
        return NViewHolder(view)
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: NViewHolder, position: Int) {
        return holder.bind(result[position])
    }
}

class NViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val imagen: ImageView = itemView.findViewById(R.id.fotica)
    private val titulo: TextView = itemView.findViewById(R.id.name)
    private val anticipado: TextView = itemView.findViewById(R.id.Noticia)
    private val valor: TextView = itemView.findViewById(R.id.Rating)

    fun bind(aNew: Resultado){
        Glide.with(itemView.context).load("http://image.tmdb.org/t/p/w500${aNew.poster_path}").into(imagen)
        titulo.text = "Title: "+aNew.title
        anticipado.text = aNew.overview
        valor.text = "Rating : "+aNew.vote_average.toString()
    }
}
