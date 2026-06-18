package com.agon.app.data

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val dao: TaskDao) {
    val tasks: Flow<List<TaskEntity>> = dao.observeAllTasks()

    suspend fun addTask(title: String) {
        val cleanTitle = title.trim()
        if (cleanTitle.isNotEmpty()) {
            dao.insertTask(TaskEntity(title = cleanTitle))
        }
    }

    suspend fun setTaskCompleted(task: TaskEntity, completed: Boolean) {
        dao.updateTask(
            task.copy(
                isCompleted = completed,
                completedAt = if (completed) System.currentTimeMillis() else null,
            ),
        )
    }

    suspend fun deleteTask(task: TaskEntity) = dao.deleteTask(task)

    suspend fun clearCompleted() = dao.deleteCompletedTasks()
}
