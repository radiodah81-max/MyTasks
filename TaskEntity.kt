package com.agon.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * نموذج المهمة المخزن في قاعدة بيانات Room.
 * completedAt يبقى فارغًا حتى يتم إنجاز المهمة.
 */
@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val completedAt: Long? = null,
)
