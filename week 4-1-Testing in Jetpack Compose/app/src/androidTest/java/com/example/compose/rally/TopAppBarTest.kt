package com.example.compose.rally

import androidx.compose.material.Text
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myTest() {
        composeTestRule.setContent {
            Text("Hi~")
        }
        fail()
    }
}