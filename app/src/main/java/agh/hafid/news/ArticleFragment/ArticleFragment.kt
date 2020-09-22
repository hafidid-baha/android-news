package agh.hafid.news.ArticleFragment

import agh.hafid.news.NewsFragment.NewsFragmentDirections
import agh.hafid.news.R
import android.icu.text.CaseMap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso

class ArticleFragment : Fragment() {

    companion object {
        fun newInstance() = ArticleFragment()
    }

    private lateinit var viewModel: ArticleViewModel
    lateinit var image:ImageView
    lateinit var title: TextView
    lateinit var date: TextView
    lateinit var content: TextView
    lateinit var btnReadMore: Button
    val args: ArticleFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.article_fragment, container, false)
        image = view.findViewById(R.id.articleImage)
        title = view.findViewById(R.id.articleTitle)
        date = view.findViewById(R.id.articleDate)
        content = view.findViewById(R.id.articleContent)
        btnReadMore = view.findViewById(R.id.readMore)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)

        Picasso.get().load(args.image).into(image)
        title.text = args.titile
        content.text = args.content
        date.text = args.date

        btnReadMore.setOnClickListener {
            val action = ArticleFragmentDirections.actionArticleFragmentToContentFragment(args.article)
            it.findNavController().navigate(action)
        }
    }

}