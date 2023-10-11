package com.bytheface1.todoapp.addtasks.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class TasksViewModel @Inject constructor():ViewModel() {

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog:LiveData<Boolean> = _showDialog

    fun dialogClose() {
        _showDialog.value = false
    }

    fun onTaskCreated(task: String) {
        Log.i("TaskCreated", task)
        _showDialog.value = false
    }

    fun onShowDialogClicked() {
        _showDialog.value = true
    }
}