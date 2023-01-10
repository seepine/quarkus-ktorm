package com.seepine.demo.common.config

import io.agroal.api.AgroalDataSource
import org.ktorm.database.Database
import javax.inject.Inject
import javax.inject.Singleton


class KtOrmConfiguration {
  @Inject
  lateinit var defaultDataSource: AgroalDataSource

  @Singleton
  fun database(): Database {
    return Database.connect(defaultDataSource)
  }
}
