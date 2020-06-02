package com.example.news.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.news.R
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.search.setOnClickListener{
            findNavController().navigate(R.id.action_nav_home_to_nav_gallery)
        }
        (activity as AppCompatActivity).supportActionBar?.title = "Home"
        return binding.root
    }
}