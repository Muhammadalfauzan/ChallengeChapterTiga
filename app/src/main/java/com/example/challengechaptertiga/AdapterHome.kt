package com.example.challengechaptertiga

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechaptertiga.databinding.ItemListBinding


class AdapterHome ( private val listMenu : ArrayList<ListData> ) :RecyclerView.Adapter<AdapterHome.ItemViewHolder>() {

    private var binding : ItemListBinding?=null
    inner class ItemViewHolder(itemBinding: ItemListBinding): RecyclerView.ViewHolder(itemBinding.root){

        val gambar : ImageView= itemView.findViewById(R.id.img_item1)
        val namaMkn : TextView = itemView.findViewById(R.id.txt_namaMkn1)
        val harga : TextView = itemView.findViewById(R.id.txt_harga1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHome.ItemViewHolder {
       binding = ItemListBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,false
       )
        return ItemViewHolder(binding!!)

    }

    override fun onBindViewHolder(holder: AdapterHome.ItemViewHolder, position: Int) {
        holder.gambar.setImageResource(listMenu[position].gambar)
        holder.namaMkn.text = listMenu[position].judul
        holder.harga.text = listMenu[position].harga
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }


}
