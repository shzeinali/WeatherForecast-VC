package com.gmail.shima.zeinalii.dev.weatherforecast.features

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.gmail.shima.zeinalii.dev.weatherforecast.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */

@HiltAndroidTest
class WFMainActivityTest {
    private val hiltRule = HiltAndroidRule(this)
    private val activityRule = ActivityScenarioRule(WFMainActivity::class.java)

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(activityRule)

    @Test
    fun onListItemClick_opensDetailPage() {
        Espresso.onView((withId(R.id.recyclerView))).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                ViewActions.click()
            )
        )
    }

    @Test
    fun scrollToLastItem() {
        activityRule.scenario.onActivity { activity ->
            val recyclerView = activity.findViewById<RecyclerView>(R.id.recyclerView)
            val itemCount = recyclerView.adapter?.itemCount
            if (itemCount != null)
                Espresso.onView((withId(R.id.recyclerView))).perform(
                    RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                        itemCount.minus(1)
                    )
                )
        }
    }

}