package com.agobikk.cookeatenjoy.ui.screens.category

import android.app.Activity
import androidx.compose.ui.test.hasText
import androidx.fragment.app.testing.FragmentScenario
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.ActivityTestRule
import com.agobikk.cookeatenjoy.MainActivity
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.ui.screens.ingredient.IngredientListAdapter
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import kotlinx.coroutines.delay
import okhttp3.internal.wait
import org.junit.Rule
import org.junit.Test
import java.util.*

class CategoryTest : TestCase(kaspressoBuilder = Kaspresso.Builder.simple().apply {
    beforeEachTest {
        ActivityScenario.launch(MainActivity::class.java)
    }
}) {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @org.junit.Test
    fun activity_AssertNotNull() {
        ActivityScenario.ActivityAction<MainActivity> {
            junit.framework.TestCase.assertNotNull(it)
        }
    }

    @Test
    fun activity_IsResumed() {
        ActivityScenario.ActivityAction<MainActivity> {
            junit.framework.TestCase.assertEquals(
                Lifecycle.State.RESUMED, activityTestRule.scenario.state
            )
        }
    }


    @Test
    fun test() =
        run {
            step("Open Simple Screen") {
                activityTestRule.scenario
                testLogger.i("I am testLogger")
                CategoryScreen {
                    recycler.act {
                        /** Ниже код экшен в стиле Espresso. Если не получается сделать что-то средствами Kakao,
                         * можно использовать Espresso над Kakao-обёртками с помощью act для экшенов или assert для ассершенов
                         */
                        actionOnItem<CategoryAdapter.CategoryViewHolder>(
                            ViewMatchers.hasDescendant(
                                ViewMatchers.withText(
                                    R.string.mainCourse
                                )
                            ), ViewActions.click()
                        )
                    }
                }
                RecipeListScreen {
                    recyclerRecipe.act {
                        actionOnItem<CategoryAdapter.CategoryViewHolder>(
                            ViewMatchers.hasDescendant(
                                ViewMatchers.withText(
                                    "Homemade Garlic and Basil French Fries"
                                )
                            ), ViewActions.click()
                        )
                    }
                }
                DetailScreen {
                    ingredientButton { click() }

                }
                IngredientScreen {
                    recyclerIngredientList.scrollToEnd()
                }


            }
        }


    @Test
    fun espressoStyleClick() = run {
        CategoryScreen {
            recycler.act {
                /** Ниже код экшен в стиле Espresso. Если не получается сделать что-то средствами Kakao,
                 * можно использовать Espresso над Kakao-обёртками с помощью act для экшенов или assert для ассершенов
                 */
                actionOnItem<CategoryAdapter.CategoryViewHolder>(
                    ViewMatchers.hasDescendant(
                        ViewMatchers.withText(
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