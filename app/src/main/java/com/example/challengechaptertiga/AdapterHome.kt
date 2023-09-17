package com.example.challengechaptertiga

import android.view.LayoutInflater

import android.view.ViewGroup


import androidx.recyclerview.widget.RecyclerView
import com.example.challengechaptertiga.databinding.ItemListBinding



class AdapterHome ( private val listMenu : ArrayList<ListData> ) :RecyclerView.Adapter<AdapterHome.ViewHolder>() {

    private lateinit var listener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(nama: String, harga: String, image:Int, deskripsi : String,lokasi : String)
    }

    class ViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    }

    fun setOnItemClickListener(listener: onItemClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imgItem1.setImageResource(listMenu[position].gambar)
        holder.binding.txtNamaMkn1.text = listMenu[position].judul
        holder.binding.txtHarga1.text = listMenu[position].harga

        holder.binding.root.setOnClickListener {
            listener.onItemClick(listMenu[position].judul, listMenu[position].harga,listMenu[position].gambar,listMenu[position].deskripsi,listMenu[position].lokasi)
        }

    }

    override fun getItemCount(): Int {
        return listMenu.size
    }


}