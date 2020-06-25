package com.willy.publisher.publisher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.willy.publisher.R
import com.willy.publisher.databinding.FragmentPublisherBinding

class PublisherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentPublisherBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_publisher, container, false
        )

        return binding.root

    }
}