package com.willy.publisher

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*


class MainViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()


    @RequiresApi(Build.VERSION_CODES.O)
    fun postArticle(newUID: String = "") {
        val post = hashMapOf(
            "author" to hashMapOf (
                "email" to "wayne@school.appworks.tw" ,
                "id" to "waynechen323" ,
                "name" to "AKA小安老師"
            ) ,
            "title" to " IU「亂穿」竟美出新境界！笑稱自己品味奇怪　網笑：靠顏值 撐住女神氣場 " ,
            "content" to " 南韓歌手IU（李知恩）無論在歌唱方面或是近期的戲劇作品 都有亮眼的成績，但俗話說人無完美、美玉微瑕，曾再跟工作人員的互動影片中坦言 自己品味很奇怪，近日在IG上分享了宛如「媽媽們青春時代的玉女歌手」超復古穿搭 造型，卻意外美出新境界。 " ,
            "createdTime" to Calendar.getInstance()
                . timeInMillis ,
            "id" to newUID,
            "tag" to "Beauty"
        )


        // Add a new article with a generated ID
        db.collection("articles")
            .add(post)
            .addOnSuccessListener { documentReference ->
                Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
                db.collection("articles")
                    .document(documentReference.id)
                    .update("id", documentReference.id)
            }
            .addOnFailureListener { e ->
                Log.w("TAG", "Error adding document", e)
            }
    }

}