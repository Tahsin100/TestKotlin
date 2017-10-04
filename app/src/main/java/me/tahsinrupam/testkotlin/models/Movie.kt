package me.tahsinrupam.testkotlin.models


/**
 * Created by Tahsin on 04-Oct-17.
 */


class Movie {
    private var title: String? = null
    private var thumbnailUrl: String? = null
    private var year: Int = 0
    private var rating: Double = 0.toDouble()
    private val genre: ArrayList<String>? = null


    fun getMoviewTitle(): String ? {
        return title
    }

    fun setMovieTitle(title: String) {
        this.title = title
    }

    fun getThumbUrl(): String ? {
        return thumbnailUrl
    }

    fun setThumbUrl(thumbnailUrl: String) {
        this.thumbnailUrl = thumbnailUrl
    }

    fun getReleaseYear(): Int {
        return year
    }

    fun setReleaseYear(year : Int) {
        this.year = year
    }

    fun getRating(): Double {
        return rating
    }

    fun setRating(year : Double) {
        this.rating = rating
    }

    fun getGenre() : ArrayList<String>? {
        return genre
    }


}


