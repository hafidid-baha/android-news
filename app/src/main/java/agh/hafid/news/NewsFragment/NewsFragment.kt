package agh.hafid.news.NewsFragment

import agh.hafid.news.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout

class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private lateinit var viewModel: NewsViewModel
    private lateinit var articleRecycler:RecyclerView
    private lateinit var shimmer:ShimmerFrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_fragment, container, false)
        shimmer = view.findViewById(R.id.shimmer)
        articleRecycler = view.findViewById(R.id.articles)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)

        viewModel.fetchNews()
        viewModel.news.observe(viewLifecycleOwner, Observer { articles->
            Toast.makeText(this.context,"items ${articles.size}",Toast.LENGTH_LONG).show()
            stopShimmer()
        })
    }

    override fun onStart() {
        super.onStart()
        shimmer.startShimmer()
    }

    override fun onPause() {
        super.onPause()
        stopShimmer()
    }

    private fun  stopShimmer(){
        shimmer.stopShimmer()
        shimmer.visibility = View.INVISIBLE
        articleRecycler.visibility = View.VISIBLE
    }

}