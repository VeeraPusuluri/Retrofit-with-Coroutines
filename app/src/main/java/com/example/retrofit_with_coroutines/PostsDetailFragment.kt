package com.example.retrofit_with_coroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.retrofit_with_coroutines.viewmodel.PostsViewModel
import com.example.retrofit_with_coroutines.databinding.FragmentPostsDetailBinding

class PostsDetailFragment : Fragment() {

    private var _binding:FragmentPostsDetailBinding? = null
    private val binding get() = _binding!!

    private val viewmodel:PostsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       _binding = FragmentPostsDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.currentPost.observe(this.viewLifecycleOwner){
            binding.tvTitleDetails.text = it.title
            binding.imgDetails.load(it.url)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}