package agh.hafid.news.MainFragment

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val app:Application = application
    fun navigateToNews(v:View){
        val action = MainFragmentDirections.actionMainFragmentToNewsFragment()
        v.findNavController().navigate(action)
    }
}