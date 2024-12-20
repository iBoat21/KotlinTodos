package it.example.todos.services

import it.example.todos.entities.TodoItem

interface TodoItemService {
    fun createTodoItem(todoId: Long, todoItem: TodoItem): TodoItem

    fun updateTodoItem(id: Long, todoItem: TodoItem): TodoItem

    fun deleteTodoItem(id: Long): TodoItem
}