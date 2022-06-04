package com.agobikk.cookeatenjoy.ui.screens.category

import androidx.compose.ui.test.hasText
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.agobikk.cookeatenjoy.MainActivity
import com.agobikk.cookeatenjoy.R
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class FragmentsTest : TestCase(kaspressoBuilder = Kaspresso.Builder.simple().apply {
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
    fun testTransitionBetweenFragments() =
        run {
            step("Check transit between screen and click to button") {
                activityTestRule.scenario
                CategoryScreen {
                    recycler.act {
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
    fun testClickFavoriteIcon() =
        run {
            step("Check transit between screen and click to button") {
                activityTestRule.scenario
                CategoryScreen {
                    recycler.act {
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
                    favoriteBtn { click() }
                    favoriteBtnBottomBar { click() }
                }
                FavoriteListScreen {
                    hasText("Homemade Garlic and Basil French Fries")
                }

            }
        }


    @Test
    fun espressoStyleClick() = run {
        CategoryScreen {
            recycler.act {
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