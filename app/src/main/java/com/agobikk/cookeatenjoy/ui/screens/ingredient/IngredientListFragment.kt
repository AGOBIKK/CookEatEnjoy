package com.agobikk.cookeatenjoy.ui.screens.ingredient

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.application.appComponent
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.repository.RepositoryImpl
import com.agobikk.cookeatenjoy.databinding.FragmentListIngredientBinding
import com.agobikk.cookeatenjoy.ui.BaseFragment
import kotlinx.coroutines.*
import timber.log.Timber
import javax.inject.Inject


class IngredientListFragment :
    BaseFragment<FragmentListIngredientBinding>(FragmentListIngredientBinding::inflate) {
    private lateinit var adapter: IngredientListAdapter
    private val args: IngredientListFragmentArgs by navArgs()

    @Inject
    lateinit var repositoryImpl: RepositoryImpl
    private var listIngredientsBD = emptyList<ExtendedIngredientEntity>()
    private fun getFoodId(): Long {
        return args.idFood
    }

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable -> Timber.d("throwable:$throwable") }
    private val scopeIo =
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler + SupervisorJob())
    private val scopeMain =
        CoroutineScope(Dispatchers.Main + coroutineExceptionHandler + SupervisorJob())
    private var job: Job? = null

    override fun onAttach(context: Context) {
        appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        displayHomeUp(true)
        init()


        job = scopeMain.launch() {

            listIngredientsBD = withContext(Dispatchers.IO) {
                return@withContext repositoryImpl.getIngredients(getFoodId()).extendedIngredientEntity
            }
            Timber.d("list ingredients from BD:${listIngredientsBD}")
            adapter.submitList(listIngredientsBD)
        }
    }

    private fun init() = with(binding) {
        adapter = IngredientListAdapter(object : OnIngredientClickListener {
            override fun onClick(extendedIngredient: ExtendedIngredientEntity) {
            }
        })
        ingredientsRecyclerview.adapter = adapter
    }

    private fun displayHomeUp(show: Boolean) {
        requireActivity().run {
            (this as AppCompatActivity).supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            supportActionBar?.setCustomView(R.layout.custom_toolbar_ingredient_fragment)
        }
    }
    override fun onDestroy() {
        scopeIo.cancel()
        scopeMain.cancel()
        super.onDestroy()
    }
}


