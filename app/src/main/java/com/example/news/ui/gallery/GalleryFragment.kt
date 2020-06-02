package com.example.news.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.news.R
import androidx.databinding.DataBindingUtil.inflate
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.network.HN
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback
import com.example.news.network.Cons
import com.example.news.network.Datos
import kotlinx.android.synthetic.main.fragment_gallery.*
import com.example.news.ui.gallery.adaptar

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private lateinit var binding: FragmentGalleryBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = inflate(inflater, R.layout.fragment_gallery, container, false)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = "Hacker News Results"
        binding.back.setOnClickListener{
            findNavController().navigate(R.id.action_nav_gallery_to_nav_home)
        }

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val request = Cons.construir(HN::class.java)
        val call = request.getNews(getString(R.string.api))

        call.enqueue(object : Callback<Datos>{
            override fun onResponse(call: Call<Datos>, response: Response<Datos>) {
                if (response.isSuccessful){

                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        adapter = adaptar(response.body()!!.resultados)
                    }
                }
            }
            override fun onFailure(call: Call<Datos>, t: Throwable) {
                Toast.makeText(activity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }




}