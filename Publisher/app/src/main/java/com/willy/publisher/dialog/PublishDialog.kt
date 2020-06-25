package com.willy.publisher.dialog

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.os.postDelayed
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.willy.publisher.FirestoreUtil
import com.willy.publisher.R
import com.willy.publisher.databinding.DialogPublishBinding

class PublishDialog : DialogFragment() {

    private val viewModel: PublishDialogViewModel by lazy {
        ViewModelProviders.of(this).get(PublishDialogViewModel::class.java)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DialogPublishBinding = DataBindingUtil
            .inflate(inflater, R.layout.dialog_publish, container, false)

        binding.viewModel = viewModel

        //Post text value to firestore
        binding.buttonSend.setOnClickListener {
            //            viewModel.checkInput()
            FirestoreUtil.postArticle(
                "",
                viewModel.enterTitle.value.toString(),
                viewModel.enterTag.value.toString(),
                viewModel.enterContent.value.toString()
            )
            Handler().postDelayed({ findNavController().navigate(R.id.navigation_publisher) }, 500)
        }

        //Test if value is input

        viewModel.enterTitle.observe(viewLifecycleOwner, Observer {
            Log.i("EditText", it)
        })

        viewModel.enterTag.observe(viewLifecycleOwner, Observer {
            Log.i("EditText", it)
        })

        viewModel.enterContent.observe(viewLifecycleOwner, Observer {
            Log.i("EditText", it)
        })



        return binding.root

    }
}