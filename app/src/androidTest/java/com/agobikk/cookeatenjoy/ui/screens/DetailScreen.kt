package com.agobikk.cookeatenjoy.ui.screens

import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeFragment
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView


object DetailScreen : KScreen<DetailScreen>() {
    override val layoutId: Int? = R.layout.fragment_detail_recipe
    override val viewClass: Class<*>? = DetailRecipeFragment::class.java

    val ingredientButton = KButton { withId(R.id.ingredient_image) }
    val image = KImageView { withId(R.id.recipe_detail_image) }
    val favoriteBtn = KButton { withId(R.id.recipe_detail_favorite_icon) }
    val favoriteBtnBottomBar = KButton { withId(R.id.favorite) }
    val ingredientText = KTextView { withId(R.id.ingredient_text) }
    val informationRecipeText = KTextView { withId(R.id.information_recipe) }

}