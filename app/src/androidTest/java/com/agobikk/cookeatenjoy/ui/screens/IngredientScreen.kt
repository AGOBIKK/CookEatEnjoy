package com.agobikk.cookeatenjoy.ui.screens

import android.view.View
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.ui.screens.ingredient.IngredientListFragment
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object IngredientScreen : KScreen<IngredientScreen>() {
    override val layoutId: Int? = R.layout.fragment_list_ingredient
    override val viewClass: Class<*>? = IngredientListFragment::class.java

    val recyclerIngredientList =
        KRecyclerView({ withId(R.id.ingredients_recyclerview) }, itemTypeBuilder = {
            itemType(::DefaultItem)
        })

    val predefinedItemsRecycler =
        KRecyclerView({ withId(R.id.ingredients_recyclerview) }, itemTypeBuilder = {
            itemType(::RecipeItem)
        })

    class DefaultItem(parent: Matcher<View>) : KRecyclerItem<DefaultItem>(parent) {
        val icon = KImageView { withId(R.id.ingredient_image) }
        val ingredientTitleTextView = KTextView { withId(R.id.ingredient_name) }
    }

    class RecipeItem(parent: Matcher<View>) : KRecyclerItem<DefaultItem>(parent) {
        val item = KTextView { withText("Main course") }
    }
}