package com.bytheface1.todoapp.addtasks.domain

import com.bytheface1.todoapp.addtasks.data.TaskRepository
import com.bytheface1.todoapp.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    operator fun invoke(): Flow<List<TaskModel>> = taskRepository.tasks
}