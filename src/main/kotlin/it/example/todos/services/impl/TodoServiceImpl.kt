package it.example.todos.services.impl

import it.example.todos.repositories.TodoRepository
import it.example.todos.services.TodoService
import it.example.todos.entities.Todo
import it.example.todos.exceptions.NotFoundException
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl (val todoRepository: TodoRepository) : TodoService {
    override fun createTodo(todo: Todo): Todo {
        return todoRepository.saveAndFlush(todo)
    }

    override fun getTodo(id: Long): Todo {
        return todoRepository.findById(id).orElseThrow {
            NotFoundException("No Todo with id $id")
        }
    }

    override fun getTodoList(): List<Todo> {
        return todoRepository.findAll()
    }

    override fun updateTodo(id: Long, todo: Todo): Todo {
        val existingTodo = todoRepository.findById(id).orElseThrow {
            NotFoundException("No Todo with id $id")
        }
        existingTodo.title = todo.title
        return todoRepository.saveAndFlush(existingTodo)
    }

    override fun deleteTodo(id: Long): Todo {
        val existingTodo = todoRepository.findById(id).orElseThrow {
            NotFoundException("No Todo with id $id")
        }
        todoRepository.delete(existingTodo)
        return existingTodo
    }
}
