package com.hopskipnfall.adventofcode2024

import com.hopskipnfall.adventofcode2024.days.day02

fun main() {
  // Use log4j as the flogger backend.
  System.setProperty(
    "flogger.backend_factory",
    "com.google.common.flogger.backend.log4j2.Log4j2BackendFactory#getInstance"
  )

  day02()
}
