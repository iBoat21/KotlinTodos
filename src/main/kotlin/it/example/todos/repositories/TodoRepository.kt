package it.example.todos.repositories

import it.example.todos.entities.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long>
