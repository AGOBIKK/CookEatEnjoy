package com.agobikk.cookeatenjoy.ui.screens

import android.view.View
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.ui.screens.recipe.RecipeListFragment
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object RecipeListScreen : KScreen<RecipeListScreen>() {
    override val layoutId: Int? = R.layout.fragment_list_recipe
    override val viewClass: Class<*>? = RecipeListFragment::class.java

    val recyclerRecipe =
        KRecyclerView({ withId(R.id.recipe_list_recyclerView) }, itemTypeBuilder = {
            itemType(::DefaultItem)
        })

    val predefinedItemsRecycler =
        KRecyclerView({ withId(R.id.recipe_list_recyclerView) }, itemTypeBuilder = {
            itemType(::RecipeItem)
        })

    class DefaultItem(parent: Matcher<View>) : KRecyclerItem<DefaultItem>(parent) {
        val icon = KImageView { withId(R.id.recipe_list_image) }
        val recipeListTitleTextView = KTextView { withId(R.id.recipe_list_title_text_view) }
    }

    class RecipeItem(parent: Matcher<View>) : KRecyclerItem<DefaultItem>(parent) {
        val item = KTextView { withText("Main course") }
    }
}