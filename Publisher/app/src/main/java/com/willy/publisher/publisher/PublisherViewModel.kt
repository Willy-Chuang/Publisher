package com.willy.publisher.publisher

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.willy.publisher.TimeUtil
import com.willy.publisher.data.Articles

class PublisherViewModel : ViewModel() {

    private val _articles = MutableLiveData<MutableList<Articles>>()

    val articles: MutableLiveData<MutableList<Articles>>
        get() = _articles


    init {
        getArticles()
    }

    // get all articles on firestore in the order of time

    fun getArticles() {
        val db = FirebaseFirestore.getInstance()
        db.collection("articles")
            .orderBy("createdTime", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->
                var listOfArticle = mutableListOf<Articles>()
                for (document in result) {

                    val article = Articles(
                        content = document.getString("content"),
                        title = document.getString("title"),
                        tag = document.getString("tag"),
                        createdTime = TimeUtil.StampToDate(document.getLong("createdTime") as Long),
                        authorName = document.getString("author.name")
                    )
                    Log.d("TAG", "${document.id} => ${document.data}")

                    listOfArticle.add(article)

                }
                articles.value = listOfArticle

            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }

    }

}