package com.willy.publisher

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.willy.publisher.data.Articles
import java.util.*

object FirestoreUtil {

    @RequiresApi(Build.VERSION_CODES.O)
    fun postArticle(newUID: String = "", title: String, tag: String, content: String) {
        val db = FirebaseFirestore.getInstance()
        val post = hashMapOf(
            "author" to hashMapOf (
                "email" to "wayne@school.appworks.tw" ,
                "id" to "waynechen323" ,
                "name" to "AKA小安老師"
            ) ,
            "title" to title,
            "content" to content ,
            "createdTime" to Calendar.getInstance()
                . timeInMillis ,
            "id" to newUID,
            "tag" to tag
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