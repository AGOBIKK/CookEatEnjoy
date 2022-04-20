package com.agobikk.cookeatenjoy.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentFeedBinding


class FeedFragment : Fragment(R.layout.fragment_feed) {
    private val viewBinding: FragmentFeedBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.feedItemView.setOnClickListener {
            findNavController().navigate(R.id.action_feedFragment_to_detailFragment)
        }
    }
}