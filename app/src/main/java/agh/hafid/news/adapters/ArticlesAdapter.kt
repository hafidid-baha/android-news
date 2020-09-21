package agh.hafid.news.adapters

import agh.hafid.news.R
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.article_item.view.*
import org.json.JSONObject

class ArticlesAdapter(var items:List<JSONObject>) : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.articleImage)
        val title:TextView = itemView.findViewById(R.id.articleTitle)
        val author:TextView = itemView.findViewById(R.id.articleAuthor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val articleItem = items.get(position)
        holder.title.text = articleItem.getString("title");
        holder.author.text = articleItem.getString("author");

        //Log.d("data", "fetchNews: image "+data.getJSONObject(0).getString("urlToImage"))
    }

    override fun getItemCount(): Int {
        return items.size
    }

}