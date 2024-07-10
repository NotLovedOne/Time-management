package com.example.myapplication.data

import com.example.myapplication.model.User

class UserRepository {
    private val userList = mutableListOf<User>()

    init {
        userList.add(User(1, "John Doe", "4566461", "asdasdsad@arisra"))
        userList.add(User(2, "mozest", "123","fistofsnake@gmail.com"))
    }

    fun getUsers(): List<User> {
        return userList.toList()
    }

    fun addUser(user: User) {
        userList.add(user)
    }
}
