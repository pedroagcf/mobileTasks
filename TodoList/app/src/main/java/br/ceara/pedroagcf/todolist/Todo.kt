package br.ceara.pedroagcf.todolist

data class Todo (
    val title: String,
    var isChecked : Boolean = false,
)