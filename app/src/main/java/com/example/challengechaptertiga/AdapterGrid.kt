package com.example.challengechaptertiga


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterGrid (private  val gridMenu : ArrayList<ListData>) : RecyclerView.Adapter<AdapterGrid.ViewHolder>(){

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        var gambar =view.findViewById<ImageView>(R.id.img_itemgrid)
        var namaMkn = view.findViewById<TextView>(R.id.textViewmkn_grid)
        var harga = view.findViewById<TextView>(R.id.txt_hargaP_grid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterGrid.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterGrid.ViewHolder, position: Int) {
    holder.gambar.setImageResource(gridMenu[position].gambar)
        holder.namaMkn.text = gridMenu[position].judul
        holder.harga.text = gridMenu[position].harga
    }

    override fun getItemCount(): Int {
        return gridMenu.size
    }


}
