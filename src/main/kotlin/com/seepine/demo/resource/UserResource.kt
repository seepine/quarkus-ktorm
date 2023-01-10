package com.seepine.demo.resource

import com.seepine.demo.entity.Status
import com.seepine.demo.entity.User
import com.seepine.demo.service.UserService
import com.seepine.tool.util.RandomUtil
import org.jboss.resteasy.reactive.RestPath
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("user")
class UserResource {
  @Inject
  lateinit var userService: UserService

  @GET
  @Path("add")
  fun add(): User {
    val user = User {
      name = RandomUtil.randomString(10)
      status = Status.NORMAL
    }
    userService.add(user)
    return user
  }

  @GET
  @Path("add/{name}")
  fun add(@RestPath name: String): User {
    val user = User {
      this.name = name
      status = Status.NORMAL
    }
    userService.add(user)
    return user
  }

  @GET
  @Path("list")
  fun list(): List<User> {
    return userService.findAll()
  }
}
