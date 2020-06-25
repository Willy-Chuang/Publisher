package com.willy.publisher.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.willy.publisher.R
import com.willy.publisher.databinding.DialogAddArticleBinding

class AddArticleDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DialogAddArticleBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_publisher, container, false)

        return binding.root

    }
}