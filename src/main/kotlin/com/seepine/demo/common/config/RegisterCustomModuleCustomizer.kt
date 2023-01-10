package com.seepine.demo.common.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import io.quarkus.jackson.ObjectMapperCustomizer
import org.ktorm.jackson.KtormModule
import javax.inject.Singleton

@Singleton
class RegisterCustomModuleCustomizer : ObjectMapperCustomizer {
  override fun customize(mapper: ObjectMapper) {
    mapper.registerModule(KtormModule())

    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)

    val longToString = SimpleModule()
    longToString.addSerializer(Long.Companion::class.java, ToStringSerializer.instance)
    mapper.registerModule(longToString)
  }
}
