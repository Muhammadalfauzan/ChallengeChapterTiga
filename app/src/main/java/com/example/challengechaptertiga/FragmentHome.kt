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
            ListData(R.drawable.pizza, "Pizza", "Rp.80.000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng","Domino's Pizza, Jl. Kyai Mojo No.91, Tegalrejo, Kec. Tegalrejo, Semarang, Daerah Istimewa Yogyakarta 55244"),
            ListData(R.drawable.miegacoan, "Mie ", "Rp.45.000","Nikmati pengalaman kuliner yang luar biasa dengan hidangan mie kami yang lezat.","Mie Gacoan Gejayan, Jl. Affandi No.9, Karang Gayam, Pelemkecut, Kec. Depok, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55222"),
            ListData(R.drawable.salmonsusi, "Salmon Sushi", "Rp.50.000","Sushi adalah aneka macam bentuk set cuka dan nasi, seperti Nigiri Sushi yaitu nasi cuka kepal yang diatasnya diberi ikan, Chirashi sushi yaitu nasi cuka yang disajikan di atas mangkuk lalu diatasnya ditaburi ikan,","Jl. Perintis No.57, Akcaya, Kec. Pontianak Sel., Kota Pontianak, Kalimantan Barat 78115"),
            ListData(R.drawable.spaghetti, "Spaghetti", "Rp.40.000"," Spaghetti Kami memulai dengan pasta spaghetti al dente yang segar dan berkualitas tinggi. Kemudian, kami sajikan dengan saus yang disiapkan secara khusus, bumbu rempah yang sempurna, dan bahan-bahan segar yang dipilih dengan hati-hati.","Yangti Spaghetti & Mac n Cheese, Jl. Teratai Perum Timoho Asri No.C3, Muja Muju, Kec. Umbulharjo, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55165"),
            ListData(R.drawable.ikanbakar, "Ikan Bakar ","Rp.20.000","Ikan Bakar Kami memulai dengan pilihan ikan segar berkualitas tinggi, yang kemudian dibumbui dengan campuran rempah-rempah dan bumbu rahasia kami. Ikan tersebut kemudian dibakar dengan sempurna hingga menjadi garing di luar dan tetap lembut dan beraroma di dalam.","Ikan Bakar Bu Bambang, Jl. Sagan Baru III No.4, RT.44/RW.09, Terban, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55223"),
            ListData(R.drawable.snack, "French fries", "Rp.25.000","We start with high-quality potatoes, cut them into thin strips, and then fry them to perfection until they are golden brown and wonderfully crisp on the outside, while remaining soft and fluffy on the inside.","McDonald's Ambarukmo, Jl. Laksda Adisucipto No.21, Ambarukmo, Caturtunggal, Kec. Depok, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55281 "),
            ListData(R.drawable.minum, "Strawberry Milk", "Rp.25.000","Our Strawberry Milk is made with care, starting with the freshest strawberries, which are blended to perfection and then mixed with cold, creamy milk.","Mixue Tugu Jogja, Jl. A.M. Sangaji No.11, Cokrodiningratan, Kec. Jetis, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55231"),
            ListData(R.drawable.dimsum, "Dim Sum", "Rp.30.0000","varian dari pangsit tradisional china yang disajikan dengan cara di kukus dan di goreng","6CQ7+W29 Modimsum - Condongcatur, Jl. Prawiro Kuat, Ngringin, Condongcatur, Depok, Sleman Regency, Special Region of Yogyakarta 55281"),
            ListData(R.drawable.ayam, "Ayam Bakar", "Rp.20.000","Ayam Bakar Kami memilih potongan ayam segar yang dipersiapkan secara khusus dengan bumbu dan rempah-rempah yang lezat, lalu dibakar dengan hati-hati hingga menghasilkan kulit yang renyah dan daging yang juicy di dalamnya","KFC Pakuwon Mall Jogja, Jl. Kaliwaru, Kaliwaru, Condongcatur, Kec. Depok, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55281"),
            ListData(R.drawable.ayammcd, "Ayam Goreng", "Rp.25.000","Ayam Goreng kami adalah hidangan yang sangat populer dan lezat yang pasti akan memanjakan lidah Anda. Kami mengambil potongan ayam berkualitas tinggi, merendamnya dalam bumbu rahasia kami yang kaya rempah-rempah, dan menggorengnya hingga keemasan yang sempurna.", "McDonald's Ambarukmo, Jl. Laksda Adisucipto No.21, Ambarukmo, Caturtunggal, Kec. Depok, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55281 "),
            ListData(R.drawable.ayammcd, "Ayam Spicy", "Rp.30.000","Ayam Goreng kami adalah hidangan yang sangat populer dan lezat yang pasti akan memanjakan lidah Anda. Kami mengambil potongan ayam berkualitas tinggi, merendamnya dalam bumbu rahasia kami yang kaya rempah-rempah, dan menggorengnya hingga keemasan yang sempurna.","Richeese Factory, Jl. Jend. Sudirman No.46, Kotabaru, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55224"),


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

