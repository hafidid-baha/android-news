package agh.hafid.news.NewsFragment

import agh.hafid.news.R
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var news:LiveData<List<String>>
    private var url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=%s"
    private var queue = Volley.newRequestQueue(application)
    private val app = application

    fun fetchNews(){
        val key = app.getString(R.string.API_KEY)
        val request = StringRequest(Request.Method.GET, url.format(key),
            Response.Listener { response ->
            Log.d("data", "fetchNews: Response is: ${response.substring(0, 500)}")
        },
            Response.ErrorListener { Log.d("data", "fetchNews: error") }
        )

        queue.add(request)
    }

}