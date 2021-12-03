package com.example.tprueba.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tprueba.databinding.FragmentHomeBinding
import com.example.tprueba.ui.models.FeedResponse
import com.example.tprueba.ui.services.ApiService
import com.example.tprueba.ui.services.RestEngine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

   connect()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun connect() {

        val apiService: ApiService = RestEngine.getRestEngine().create(ApiService::class.java)
        val result: Call<List<FeedResponse>> = apiService.getFeed()
        result.enqueue(object : Callback<List<FeedResponse>> {
            override fun onResponse(call: Call<List<FeedResponse>>, response: Response<List<FeedResponse>>) {
                var adapter = HomeAdapter(response)
                Toast.makeText(requireContext(), "ok", Toast.LENGTH_SHORT).show()
                binding.feedRecyclerView.setHasFixedSize(true)
                binding.feedRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                binding.feedRecyclerView.adapter = adapter

            }

            override fun onFailure(call: Call<List<FeedResponse>>, t: Throwable) {
                Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}