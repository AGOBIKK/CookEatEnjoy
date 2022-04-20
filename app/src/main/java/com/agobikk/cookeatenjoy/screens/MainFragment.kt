package com.agobikk.cookeatenjoy.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.agobikk.cookeatenjoy.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment(R.layout.fragment_main) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView =
            view.findViewById<BottomNavigationView>(R.id.mainBottomNavigationView)
        val navController =
            (childFragmentManager.findFragmentById(R.id.mainContainerView) as NavHostFragment)
                .navController
        bottomNavigationView.setupWithNavController(navController)
    }
}