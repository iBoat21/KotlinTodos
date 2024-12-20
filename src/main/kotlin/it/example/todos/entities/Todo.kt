package it.example.todos.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

// Entity, GeneratedValue, Id, JoinColumn, OneToMany, Table

@Entity
@Table(name = "todo")
class Todo(
    @Id
    @GeneratedValue
    val id: Long = 0,
    var title: String = "",
    // type eager = ทำให้สามารถหยิบ class ปัจจุบันและ class ที่กำลังจะสร้างในอนาคตได้
    @OneToMany(mappedBy = "todo", fetch = FetchType.EAGER, cascade = [CascadeType.REMOVE], orphanRemoval = true)
    var todoItem: MutableList<TodoItem> = mutableListOf()
) {
    override fun toString(): String {
        return "Todo(id=$id, title=$title, todoItem=$todoItem)"
    }
}