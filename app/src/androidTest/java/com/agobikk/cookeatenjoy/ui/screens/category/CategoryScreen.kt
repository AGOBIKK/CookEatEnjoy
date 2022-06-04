package com.agobikk.cookeatenjoy.ui.screens.category

import android.view.View
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeFragment
import com.agobikk.cookeatenjoy.ui.screens.favorite.FavoriteFragment
import com.agobikk.cookeatenjoy.ui.screens.ingredient.IngredientListFragment
import com.agobikk.cookeatenjoy.ui.screens.recipe.RecipeListFragment
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object CategoryScreen : KScreen<CategoryScreen>() {
    override val layoutId: Int? = R.layout.fragment_category
    override val viewClass: Class<*>? = CategoryFragment::class.java

    val recycler = KRecyclerView({ withId(R.id.categoryListRecyclerView) }, itemTypeBuilder = {
        itemType(::DefaultItem)
    })

    val predefinedItemsRecycler =
        KRecyclerView({ withId(R.id.categoryListRecyclerView) }, itemTypeBuilder = {
            itemType(::CategoryItem)
        })

    class DefaultItem(parent: Matcher<View>) : KRecyclerItem<DefaultItem>(parent) {
        val icon = KImageView { withId(R.id.category_image) }
        val item = KTextView { withId(R.id.category_title) }
    }

    class CategoryItem(parent: Matcher<View>) : KRecyclerItem<DefaultItem>(parent) {
        val item = KTextView { withText("Main course") }
    }

}

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

object DetailScreen : KScreen<DetailScreen>() {
    override val layoutId: Int? = R.layout.fragment_detail_recipe
    override val viewClass: Class<*>? = DetailRecipeFragment::class.java

    val ingredientButton = KButton { withId(R.id.ingredient_image) }
    val image = KImageView { withId(R.id.recipe_detail_image) }
    val favoriteBtn = KButton { withId(R.id.recipe_detail_favorite_icon) }
    val favoriteBtnBottomBar = KButton { withId(R.id.favorite) }
}

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

object FavoriteListScreen : KScreen<FavoriteListScreen>() {
    override val layoutId: Int? = R.layout.fragment_favorite
    override val viewClass: Class<*>? = FavoriteFragment::class.java

    val recyclerRecipe =
        KRecyclerView({ withId(R.id.recipe_favorite_recyclerView) }, itemTypeBuilder = {
            itemType(::DefaultItem)
        })

    val predefinedItemsRecycler =
        KRecyclerView({ withId(R.id.recipe_favorite_recyclerView) }, itemTypeBuilder = {
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



