package agh.hafid.news.adapters

import agh.hafid.news.R
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_item.view.*
import org.json.JSONObject

class ArticlesAdapter(var items:List<JSONObject>) : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image:ImageView = itemView.findViewById(R.id.articleImage)
        val title:TextView = itemView.findViewById(R.id.articleTitle)
        val author:TextView = itemView.findViewById(R.id.articleAuthor)
        val card:MaterialCardView = itemView.findViewById(R.id.card)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val articleItem = items.get(position)
        val imageUrl = articleItem.getString("urlToImage")
        holder.title.text = articleItem.getString("title");
        holder.author.text = if (articleItem.getString("author").toString() != "null")  "BY : "+articleItem.getString("author").toString() else "BY : Unknown";

        Picasso.get().load(imageUrl).into(holder.image)
        holder.card.setOnClickListener{
            Toast.makeText(it.context,"clicked",Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}