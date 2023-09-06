package com.example.compareapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun onCompareClick_sameText_setsResultToEqual() {
        // Introduce texto en los EditText
        onView(withId(R.id.editText1)).perform(typeText("texto"))
        onView(withId(R.id.editText2)).perform(typeText("texto"))

        // Hace clic en el botón "Comparar"
        onView(withId(R.id.button)).perform(click())

        // Verifica el resultado
        onView(withId(R.id.textView)).check(matches(withText("Las cadenas son iguales")))
    }

    @Test
    fun onCompareClick_differentText_setsResultToDifferent() {
        // Introduce texto en los EditText
        onView(withId(R.id.editText1)).perform(typeText("texto1"))
        onView(withId(R.id.editText2)).perform(typeText("texto2"))

        // Hace clic en el botón "Comparar"
        onView(withId(R.id.button)).perform(click())

        // Verifica el resultado
        onView(withId(R.id.textView)).check(matches(withText("Las cadenas son diferentes")))
    }
}
