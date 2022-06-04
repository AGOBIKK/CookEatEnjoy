package com.agobikk.cookeatenjoy.ui.screens.category

import android.app.Activity
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.matcher.ViewMatchers
import com.agobikk.cookeatenjoy.MainActivity
import com.agobikk.cookeatenjoy.R
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Test

class CategoryTest: TestCase(kaspressoBuilder = Kaspresso.Builder.simple().apply {
    beforeEachTest {
        ActivityScenario.launch(MainActivity::class.java)
    }
})  {

    @Test
    fun espressoStyleClick() = run {
        CategoryScreen {
            recycler.act {
                /** Ниже код экшен в стиле Espresso. Если не получается сделать что-то средствами Kakao,
                 * можно использовать Espresso над Kakao-обёртками с помощью act для экшенов или assert для ассершенов
                 */
                actionOnItem<CategoryAdapter.CategoryViewHolder>(
                    ViewMatchers.hasDescendant(
                        ViewMatchers.withText (
                            R.string.mainCourse
                        )
                    ), ViewActions.click()
                )
            }
        }
    }

    /**
     * Пример клика со стандартными item type для [com.agoda.kakao.recycler.KRecyclerView]
     */
    @Test
    fun kakaoStyleClick() = run {
        CategoryScreen {
            recycler {
                childWith<CategoryScreen.DefaultItem> {
                    withDescendant { ViewMatchers.withText("Main course") }
                } perform { ViewActions.click() }
            }
        }
    }

    /**
     * Пример клика с кастомными item type для [com.agoda.kakao.recycler.KRecyclerView]
     */
    @Test
    fun kakaoStyleWithCustomItemTypesClick() = run {
        CategoryScreen {
            predefinedItemsRecycler {
                firstChild<CategoryScreen.CategoryItem> {
                    ViewActions.click()
                }
            }
        }
    }
}