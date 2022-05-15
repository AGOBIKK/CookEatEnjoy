package com.agobikk.cookeatenjoy.ui.screens.ingredient

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentListIngredientBinding
import com.agobikk.cookeatenjoy.model.ExtendedIngredient
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeFragment
import kotlinx.coroutines.*
import timber.log.Timber


class IngredientListFragment : Fragment(R.layout.fragment_list_ingredient) {
    private val viewBinding: FragmentListIngredientBinding by viewBinding()
    private lateinit var adapter: IngredientListAdapter
    private val viewModel: IngredientViewModel by viewModels()
    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable -> Timber.d("throwable:$throwable") }
    private val scope =
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler + SupervisorJob())
    private var job: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        init()


        adapter.submitList(DetailRecipeFragment.ingredientsList)

    }

    private fun init() = with(viewBinding) {
        adapter = IngredientListAdapter(object : OnIngredientClickListener {
            override fun onClick(extendedIngredient: ExtendedIngredient) {

            }
        })
        viewBinding.ingredientsRecyclerview.adapter = adapter
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }
}


