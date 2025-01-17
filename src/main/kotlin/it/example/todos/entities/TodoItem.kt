package it.example.todos.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "to_item")
class TodoItem(
    @Id
    @GeneratedValue
    val id: Long = 0,
    var content: String = "",
    var isComplete: Boolean = false,
    @ManyToOne
    @JoinColumn(name = "todo_id")
    @JsonIgnore
    var todo: Todo? = null
) {
    override fun toString(): String {
        return "TodoItem(id=$id, content=$content, isComplete=$isComplete, todo=$todo)"
    }
}