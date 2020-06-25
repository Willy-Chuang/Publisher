package com.willy.publisher.dialog

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.willy.publisher.TheApp

class PublishDialogViewModel : ViewModel() {

    val enterTitle = MutableLiveData<String>()

    val enterTag = MutableLiveData<String>()

    val enterContent = MutableLiveData<String>()

//    // Check if info is filled
//    fun checkInput(): Boolean {
//        if (enterTitle.value != null && enterTag.value != null && enterContent.value != null) {
//            Toast.makeText(TheApp.appContext, "發文成功", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(TheApp.appContext, "請填寫完整", Toast.LENGTH_SHORT).show()
//        }
//        return true
//    }


}