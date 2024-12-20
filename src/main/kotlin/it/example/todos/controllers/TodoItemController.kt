package it.example.todos.controllers

import it.example.todos.entities.TodoItem
import it.example.todos.services.TodoItemService
import org.springframework.beans.factory.annotation.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/todos")
class TodoItemsController @Autowired constructor(val todoItemService: TodoItemService) {
    @PostMapping("/{todoId}/items")
    fun createTodoItem(@PathVariable(name = "todoId") todoId: Long,
                       @RequestBody todoItem: TodoItem): ResponseEntity<TodoItem> {
        return ResponseEntity(todoItemService.createTodoItem(todoId, todoItem), HttpStatus.CREATED)
    }

    @PutMapping("/items/{id}")
    fun updateTodoItem(@PathVariable id: Long, @RequestBody todoItem: TodoItem): TodoItem {
        return todoItemService.updateTodoItem(id, todoItem)
    }

    @DeleteMapping("/items/{id}")
    fun deleteTodoItem(@PathVariable id: Long): TodoItem {
        return todoItemService.deleteTodoItem(id)
    }
}
