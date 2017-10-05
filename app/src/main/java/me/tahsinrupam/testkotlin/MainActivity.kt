package me.tahsinrupam.testkotlin

import android.app.DownloadManager
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import me.tahsinrupam.testkotlin.adapters.MovieRecyclerAdapter
import me.tahsinrupam.testkotlin.models.Movie
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {


    val Artist : String ?= "Artist string"
    val url : String ?= "https://api.androidhive.info/json/movies.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(isNetworkConnected()) {
            loadNetworkData()
        }
        else
            Toast.makeText(applicationContext, "No network.", Toast.LENGTH_SHORT).show()
    }




    private fun isNetworkConnected(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo as NetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }



    fun loadNetworkData(){
        val requestQueue = Volley.newRequestQueue(this) as RequestQueue
        val request = JsonArrayRequest (Request.Method.GET, url , null,
                Response.Listener <JSONArray> { response ->

                    val movie  =  Movie ()
                    val count : Int  =  response.length()
                    var movies : MutableList<Movie>  = mutableListOf()
                    val readOnlyView: List<Movie> = movies as MutableList<Movie>

                    repeat(count){ i ->

                        val singleMovieJsonObj : JSONObject ? = response.getJSONObject(i)
                        if (singleMovieJsonObj != null) {
                            movie.setMovieTitle(singleMovieJsonObj.getString("title"))
                            movie.setThumbUrl(singleMovieJsonObj.getString("image"))
                            movie.setThumbUrl(singleMovieJsonObj.getString("rating"))
                            movie.setReleaseYear(singleMovieJsonObj.getInt("releaseYear"))

                            val genreArray : JSONArray ? = singleMovieJsonObj.getJSONArray("genre")
                            val genre: MutableList<String> = mutableListOf()
                            val readOnlyViewG: List<String> = genre
                            if (genreArray != null) {
                                repeat(genreArray.length()){ k ->
                                    genre += genreArray.get(k).toString()
                                    Log.d("genre->", genre[k])
                                }
                                movie.setGenre(genre)
                            }

                        }
                        movies!!.add(movie)
                        recyclerViewMovie.adapter = MovieRecyclerAdapter(movies)

                    }

                },
                Response.ErrorListener {
                    Toast.makeText(this, "That didn't work!", Toast.LENGTH_SHORT).show()
                }
        )
        requestQueue.add(request)



    }
}
