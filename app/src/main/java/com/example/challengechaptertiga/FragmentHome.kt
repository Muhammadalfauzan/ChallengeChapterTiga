package com.example.challengechaptertiga


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechaptertiga.databinding.FragmentHomeBinding


class FragmentHome : Fragment() {

    private var _binding : FragmentHomeBinding?                         = null
    private val binding get()                                                   = _binding!!
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding?.root
    }

    private var isGridView = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = arrayListOf(
            ListData(R.drawable.ayam, "Ayam Bakar", "Rp.20.000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng","https://maps.app.goo.gl/bKWJUJoVZ9bxAo3j8"),
            ListData(R.drawable.ayamgoreng, "Ayam Goreng", "Rp.25.0000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng", "jalan maguwoharjo "),
            ListData(R.drawable.ayamspicy, "Ayam Spicy", "Rp.30.000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng","jln sukun"),
            ListData(R.drawable.dimsum, "Dim Sum", "Rp.30.0000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng","jalan sukun"),
            ListData(R.drawable.pizza, "Pizza", "Rp.80.000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng","jalan sukun"),
            ListData(R.drawable.mie1, "Mie ", "Rp.20.000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng","jalan sukun"),
            ListData(R.drawable.salmonsusi, "Salmon Sushi", "Rp.20.000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng","jalan sukun"),
            ListData(R.drawable.spaghetti, "Spaghetti", "Rp.40.000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng","jalan sukun"),
            ListData(R.drawable.ikanbakar3, "Ikan Bakar ","Rp.20.000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng","jalan sukun"),
            ListData(R.drawable.snack, "French fries", "Rp.15.000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng","jalan sukun"),
            ListData(R.drawable.minum2, "Strawberry Milk", "Rp.25.000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng","jalan sukun"),
        )

        val btnswitchlist = view.findViewById<ImageButton>(R.id.btn_switch)
        var adapterHome = AdapterHome(list)
        var adapterGrid = AdapterGrid(list)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvListMenu)
        var layoutmanager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutmanager
        var layoutmanagergrid = GridLayoutManager(context, 2)

        var listlayout = true

// Set tampilan awal sesuai dengan listlayout
        if (listlayout) {
            btnswitchlist.setImageResource(R.drawable.list)
            recyclerView.layoutManager = layoutmanager
            recyclerView.adapter = adapterHome
        } else {
            btnswitchlist.setImageResource(R.drawable.baseline_grid_view_24)
            recyclerView.layoutManager = layoutmanagergrid
            recyclerView.adapter = adapterGrid
        }

        btnswitchlist.setOnClickListener {
            listlayout = !listlayout
            if (listlayout) {
                btnswitchlist.setImageResource(R.drawable.list)
                recyclerView.layoutManager = layoutmanager
                recyclerView.adapter = adapterHome
            } else {
                btnswitchlist.setImageResource(R.drawable.baseline_grid_view_24)
                recyclerView.layoutManager = layoutmanagergrid
                recyclerView.adapter = adapterGrid
            }
        }
        //list layout
        adapterHome.setOnItemClickListener(object: AdapterHome.onItemClickListener{
            override fun onItemClick( nama: String, harga: String,image: Int,deskripsi : String, lokasi: String) {
                val bund = Bundle()
                bund.putString("nama",nama)
                bund.putString("harga",harga)
                bund.putInt("image",image)
                bund.putString("deskripsi",deskripsi)
                bund.putString("lokasi",lokasi)

                Navigation.findNavController(binding.root).navigate(R.id.action_fragmentHome_to_fragmentDetail,bund)


            }
        })

        // grid layout
        adapterGrid.setOnItemClickListener(object : AdapterGrid.onItemClickListener{
            override fun onItemClick(
                nama: String,
                harga: String,
                image: Int,
                deskripsi: String,
                lokasi: String
            ) {
                val bundle = Bundle()
                bundle.putString("nama",nama)
                bundle.putString("harga",harga)
                bundle.putInt("image",image)
                bundle.putString("deskripsi",deskripsi)
                bundle.putString("lokasi",lokasi)

                Navigation.findNavController(binding.root).navigate(R.id.action_fragmentHome_to_fragmentDetail,bundle)
            }
        })
    }
}

