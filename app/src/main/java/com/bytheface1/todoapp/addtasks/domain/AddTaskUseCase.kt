package com.bytheface1.todoapp.addtasks.domain

import com.bytheface1.todoapp.addtasks.data.TaskRepository
import com.bytheface1.todoapp.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(taskModel: TaskModel) {
        taskRepository.add(taskModel)
    }
}