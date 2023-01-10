package com.seepine.demo.entity

import io.quarkus.runtime.annotations.RegisterForReflection
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.enum
import org.ktorm.schema.int
import org.ktorm.schema.varchar

@RegisterForReflection
enum class Status {
  NORMAL, SUSPEND
}

interface User : Entity<User> {
  companion object : Entity.Factory<User>()

  var id: Int
  var name: String
  var status: Status
}

object Users : Table<User>("user") {
  val id = int("id").bindTo { it.id }
  val name = varchar("name").bindTo { it.name }
  val status = enum<Status>("status").bindTo { it.status }
}
