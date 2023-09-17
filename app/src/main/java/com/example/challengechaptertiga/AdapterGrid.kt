package com.example.challengechaptertiga


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechaptertiga.databinding.ItemGridBinding

class AdapterGrid (private  val gridMenu : ArrayList<ListData>) : RecyclerView.Adapter<AdapterGrid.ViewHolder>(){
    private lateinit var listenergrid: AdapterHome.onItemClickListener

    interface onItemClickListener : AdapterHome.onItemClickListener {
        override
        fun onItemClick(nama: String, harga: String, image:Int, deskripsi : String, lokasi : String)
    }
    class ViewHolder(val binding: ItemGridBinding): RecyclerView.ViewHolder(binding.root) {

    }

    fun setOnItemClickListener(listenergrid: onItemClickListener){
        this.listenergrid = listenergrid
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view = ItemGridBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AdapterGrid.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterGrid.ViewHolder, position: Int) {
    holder.binding.imgGrid.setImageResource(gridMenu[position].gambar)
        holder.binding.tvNamaMknGrid.text= (gridMenu[position].judul)
        holder.binding.tvHargaGrid.text= (gridMenu[position].harga)

        holder.binding.root.setOnClickListener{
            listenergrid.onItemClick(gridMenu[position].judul, gridMenu[position].harga,gridMenu[position].gambar,gridMenu[position].deskripsi,gridMenu[position].lokasi)
        }

    }

    override fun getItemCount(): Int {
        return gridMenu.size
    }


}
