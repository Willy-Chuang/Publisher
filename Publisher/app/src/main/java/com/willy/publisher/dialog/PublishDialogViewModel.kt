package com.willy.publisher.dialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PublishDialogViewModel : ViewModel(){

    val enterTitle = MutableLiveData<String>()

    val enterTag = MutableLiveData<String>()

    val enterContent = MutableLiveData<String>()


}