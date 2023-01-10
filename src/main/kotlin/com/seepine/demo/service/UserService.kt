package com.seepine.demo.service

import com.seepine.demo.common.ktorm.BaseService
import com.seepine.demo.entity.User
import com.seepine.demo.entity.Users
import javax.inject.Singleton

@Singleton
class UserService : BaseService<User, Users>(Users) {
}
