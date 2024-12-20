package it.example.todos.repositories

import it.example.todos.entities.TodoItem
import org.springframework.data.jpa.repository.JpaRepository

interface TodoItemRepository : JpaRepository<TodoItem, Long>