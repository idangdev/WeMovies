package com.wildan.wemovies.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildan.wemovies.core.ui.MoviesAdapter
import com.wildan.wemovies.databinding.FragmentHomeBinding
import com.wildan.wemovies.detail.DetailMoviesActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val moviesAdapter = MoviesAdapter()
            moviesAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMoviesActivity::class.java)
                intent.putExtra(DetailMoviesActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.movies.observe(viewLifecycleOwner, { movies ->
                when (movies) {
                    is com.wildan.wemovies.core.data.Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is com.wildan.wemovies.core.data.Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        moviesAdapter.setData(movies.data)
                    }
                    is com.wildan.wemovies.core.data.Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Maaf terjadi error", Toast.LENGTH_SHORT).show()
                    }
                }
            })

            with(binding.rvMovies){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = moviesAdapter
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}