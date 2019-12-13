package com.example.testapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    private val mName = "Tony"

    @Before
    @Throws(Exception::class)
    fun setUp() {

    }

    @Test
    fun testUserInputScenario() {
        // input some text in the edit text
        Espresso.onView(withId(R.id.edTextView)).perform(typeText(mName))
        // close soft keyboard
        Espresso.closeSoftKeyboard()
        // perform button click
        Espresso.onView(withId(R.id.btnChange)).perform(click())
        // checking the text in the textview
        Espresso.onView(withId(R.id.tvTextView)).check(matches(withText(mName)))
    }


    @After
    @Throws(Exception::class)
    fun tearDown() {

    }
}