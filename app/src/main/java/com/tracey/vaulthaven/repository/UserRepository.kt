package com.tracey.vaulthaven.repository


import com.tracey.vaulthaven.data.UserDao
import com.tracey.vaulthaven.model.User


class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}