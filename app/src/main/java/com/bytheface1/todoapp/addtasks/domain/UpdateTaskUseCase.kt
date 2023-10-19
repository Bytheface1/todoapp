package com.bytheface1.todoapp.addtasks.domain

import com.bytheface1.todoapp.addtasks.data.TaskRepository
import com.bytheface1.todoapp.addtasks.ui.model.TaskModel
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(taskModel: TaskModel) {
        taskRepository.update(taskModel)
    }
}