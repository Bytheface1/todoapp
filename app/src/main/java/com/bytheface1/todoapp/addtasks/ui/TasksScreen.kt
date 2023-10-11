package com.bytheface1.todoapp.addtasks.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog


@Composable
fun TasksScreen(tasksViewModel: TasksViewModel) {

    val showDialog: Boolean by tasksViewModel.showDialog.observeAsState(initial = false)

    Box(modifier = Modifier.fillMaxSize()) {
        AddTasksDialog(
            show = showDialog,
            onDismiss = { tasksViewModel.dialogClose() },
            onTaskAdded = { tasksViewModel.onTaskCreated(it) })
        FabDialog(Modifier.align(Alignment.BottomEnd), tasksViewModel)

    }
}

@Composable
fun FabDialog(modifier: Modifier, tasksViewModel: TasksViewModel) {
    FloatingActionButton(onClick = {
        tasksViewModel.onShowDialogClicked()
    }, modifier = modifier.padding(16.dp)) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTasksDialog(show: Boolean, onDismiss: () -> Unit, onTaskAdded: (String) -> Unit) {
    var myTask by rememberSaveable {
        mutableStateOf("")
    }
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Add your task",
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold
                )
                TextField(
                    value = myTask,
                    onValueChange = { myTask = it },
                    singleLine = true,
                    maxLines = 1
                )
                Button(onClick = {
                    onTaskAdded(myTask)
                }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Add task")
                }
            }
        }
    }
}
