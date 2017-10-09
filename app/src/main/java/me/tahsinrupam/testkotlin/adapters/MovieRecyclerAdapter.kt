package me.tahsinrupam.testkotlin.adapters

import android.content.Context
import android.support.constraint.R.id.parent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_movie_layout.view.*
import me.tahsinrupam.testkotlin.R
import me.tahsinrupam.testkotlin.models.Movie


/**
 * Created by Tahsin on 05-Oct-17.
 */

class MovieRecyclerAdapter(private val movieList: MutableList<Movie>) : RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
   /* override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.single_movie_layout, parent, false)
        return ViewHolder(v)
    }*/

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: MovieRecyclerAdapter.ViewHolder, position: Int) {
        holder.bindItems(movieList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return movieList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: Movie) {

            Picasso.with(itemView.context)
                    .load(user.thumbUrl)
                    .into(itemView.imageViewThumb)
            itemView.textViewGenre.text = "Genre: "
            itemView.textViewTitle.text=user.title
            itemView.textViewRating.text = "Rating: " + user.rating.toString()
            repeat(user.genre.size)  { i ->
                itemView.textViewGenre.append(user.genre[i])
                if(i < user.genre.size - 1)
                    itemView.textViewGenre.append(", ")
            }

            itemView.textViewYear.text = user.year.toString()

        }
    }

}
