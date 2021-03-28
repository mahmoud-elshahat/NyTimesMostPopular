package com.mahmoudelshahat.nytimesmp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.mahmoudelshahat.nytimesmp.ui.PostsActivity
import com.mahmoudelshahat.nytimesmp.ui.PostsRecyclerAdapter
import com.mahmoudelshahat.nytimesmp.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class PostsActivityTest
{
    @get:Rule
    val activityRule:ActivityScenarioRule<PostsActivity> = ActivityScenarioRule(PostsActivity::class.java)
    @Before
    fun registerIdlingResource()
    {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }
    @After
    fun unRegisterIdlingResource()
    {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }



    @Test
    fun test_isActivityInView(){
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_clickListItem()
    {
        onView(withId(R.id.recycler))
            .perform(actionOnItemAtPosition<PostsRecyclerAdapter.PostsViewHolder>(4, click()))
        onView(withId(R.id.posts_layout)).check(matches(isDisplayed()))

    }

}