package com.willy.publisher.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Articles(
    val title: String? = "",
    var content: String? = "",
    val createdTime: String? = "",
    val id: String? = "",
    val tag: String? = "",
    val authorName: String? = ""
) : Parcelable

@Parcelize
data class Author(
    val email: String? = "",
    val id: String? = "",
    val name: String? = ""
) : Parcelable