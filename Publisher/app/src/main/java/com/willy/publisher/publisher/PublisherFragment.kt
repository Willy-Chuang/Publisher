package com.willy.publisher.publisher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.willy.publisher.R
import com.willy.publisher.databinding.FragmentPublisherBinding

class PublisherFragment : Fragment() {

    private val viewModel: PublisherViewModel by lazy {
        ViewModelProviders.of(this).get(PublisherViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentPublisherBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_publisher, container, false
        )
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        val adapter = PublisherAdapter()

        binding.recyclerView.adapter = adapter

        binding.addButton.setOnClickListener{
            findNavController().navigate(R.id.navigation_dialog)
        }






        viewModel.articles.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root

    }
}