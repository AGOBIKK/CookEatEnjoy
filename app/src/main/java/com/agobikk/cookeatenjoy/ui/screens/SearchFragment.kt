package com.agobikk.cookeatenjoy.ui.screens

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.agobikk.cookeatenjoy.R

class SearchFragment : Fragment(R.layout.fragment_search) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        displayHomeUp(true)
    }

    private fun displayHomeUp(show: Boolean) {
        requireActivity().run {
            (this as AppCompatActivity).supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            supportActionBar?.setCustomView(R.layout.custom_toolbar_search_fragment)
        }
    }
}