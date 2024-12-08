package com.hopskipnfall

import com.google.common.flogger.FluentLogger

private val logger = FluentLogger.forEnclosingClass()

fun main() {
  // Use log4j as the flogger backend.
  System.setProperty(
    "flogger.backend_factory",
    "com.google.common.flogger.backend.log4j2.Log4j2BackendFactory#getInstance"
  )

  logger.atInfo().log("Hello World")
}
