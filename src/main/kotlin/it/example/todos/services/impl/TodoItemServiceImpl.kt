package it.example.todos.services.impl

import it.example.todos.entities.TodoItem
import it.example.todos.exceptions.NotFoundException
import it.example.todos.repositories.TodoItemRepository
import it.example.todos.repositories.TodoRepository
import it.example.todos.services.TodoItemService
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.Service

@Service
class TodoItemServiceImpl @Autowired constructor(
    val todoRepository: TodoRepository,
    val todoItemRepository: TodoItemRepository
) : TodoItemService {

    override fun createTodoItem(todoId: Long, todoItem: TodoItem): TodoItem {
        val todo = todoRepository.findById(todoId).orElseThrow {
            NotFoundException("No Todo with id $todoId")
        }
        todoItem.todo = todo
        return todoItemRepository.saveAndFlush(todoItem)
    }

    override fun updateTodoItem(id: Long, todoItem: TodoItem): TodoItem {
        val existingItem = todoItemRepository.findById(id).orElseThrow {
            NotFoundException("No TodoItem with id $id")
        }
        existingItem.content = todoItem.content
        existingItem.isComplete = todoItem.isComplete
        return todoItemRepository.saveAndFlush(existingItem)
    }

    override fun deleteTodoItem(id: Long): TodoItem {
        val existingItem = todoItemRepository.findById(id).orElseThrow {
            NotFoundException("No TodoItem with id $id")
        }
        todoItemRepository.delete(existingItem)
        return existingItem
    }
}
