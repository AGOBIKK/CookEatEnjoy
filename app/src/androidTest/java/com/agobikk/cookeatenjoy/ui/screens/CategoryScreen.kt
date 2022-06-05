package com.agobikk.cookeatenjoy.ui.screens

import android.view.View
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.ui.screens.category.CategoryFragment
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
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








