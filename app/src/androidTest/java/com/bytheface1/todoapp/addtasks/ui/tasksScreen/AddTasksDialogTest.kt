package com.bytheface1.todoapp.addtasks.ui.tasksScreen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.bytheface1.todoapp.addtasks.ui.AddTasksDialog
import org.junit.Rule
import org.junit.Test

class AddTasksDialogTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenDialogGetATrue_thenShowDialog(){
        composeTestRule.setContent {
            AddTasksDialog(show = true, onDismiss = {}, onTaskAdded = {})
        }

        composeTestRule.onNodeWithTag("dialog").assertIsDisplayed()
    }

    @Test
    fun whenDialogGetAFalse_thenDoNotShowDialog(){
        composeTestRule.setContent {
            AddTasksDialog(show = false, onDismiss = {}, onTaskAdded = {})
        }

        composeTestRule.onNodeWithTag("dialog").assertDoesNotExist()
    }

}