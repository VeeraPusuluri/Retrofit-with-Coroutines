package com.example.retrofit_with_coroutines

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.retrofit_with_coroutines.adapter.RecyclerviewAdapter
import com.example.retrofit_with_coroutines.databinding.FragmentPostsBinding
import com.example.retrofit_with_coroutines.viewmodel.PostsViewModel

private const val TAG = "RecyclerviewFragment"

class RecyclerviewFragment : Fragment() {

    private var _binding: FragmentPostsBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerview: RecyclerView
    private lateinit var slidingPaneLayout: SlidingPaneLayout

    val viewmodel: PostsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "recyclerview fragment onViewCreated")
        recyclerview = binding.recyclerviewPhotos
        slidingPaneLayout = binding.slidingPane
        slidingPaneLayout.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            PostsListSlidingPaneLayout(slidingPaneLayout)
        )
        val adapter = RecyclerviewAdapter {
            viewmodel.setCurrentPost(it)
            binding.slidingPane.openPane()
        }
        viewmodel.imagesList.observe(requireActivity()) {
            recyclerview.layoutManager = LinearLayoutManager(requireContext())
            recyclerview.adapter = adapter
            adapter.submitList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

class PostsListSlidingPaneLayout(private val slidingPaneLayout: SlidingPaneLayout) :
    OnBackPressedCallback(slidingPaneLayout.isSlideable && slidingPaneLayout.isOpen),
    SlidingPaneLayout.PanelSlideListener {

    init {
        slidingPaneLayout.addPanelSlideListener(this)
    }

    override fun handleOnBackPressed() {
        slidingPaneLayout.closePane()
    }

    override fun onPanelSlide(panel: View, slideOffset: Float) {
    }

    override fun onPanelOpened(panel: View) {
        isEnabled = true
    }

    override fun onPanelClosed(panel: View) {
        isEnabled = false
    }
}