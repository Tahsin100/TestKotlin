package me.tahsinrupam.testkotlin.models


/**
 * Created by Tahsin on 04-Oct-17.
 */


class Movie {
    private var title: String? = null
    private val thumbnailUrl: String? = null
    private val year: Int = 0
    private val rating: Double = 0.toDouble()
    private val genre: ArrayList<String>? = null


    fun getMoviewTitle(): String ? {
        return title
    }

    fun setMovieTitle(title: String) {
        this.title = title
    }




}


