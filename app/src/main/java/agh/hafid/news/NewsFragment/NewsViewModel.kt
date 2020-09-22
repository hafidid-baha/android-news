package agh.hafid.news.NewsFragment

import agh.hafid.news.R
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    val news = MutableLiveData<List<JSONObject>>()
    private var url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=%s"
    private var queue = Volley.newRequestQueue(application)
    private val app = application

    fun fetchNews(){
        val key = app.getString(R.string.API_KEY)
        val request = StringRequest(Request.Method.GET, url.format(key),
            { response ->
                val data = JSONObject(response).getJSONArray("articles")
                val articles = mutableListOf<JSONObject>()
                var m:JSONObject = JSONObject()
                for (i in 0 until data.length()) {
                    articles.add(data.getJSONObject(i))
                }
                news.value = articles
                //Log.d("data", "fetchNews: $data")

            },
            { Log.d("data", "fetchNews: error") }
        )

        queue.add(request)
    }



}