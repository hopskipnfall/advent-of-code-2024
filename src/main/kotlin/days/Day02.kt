package com.hopskipnfall.adventofcode2024.days

import com.google.common.flogger.FluentLogger
import kotlin.math.abs
import org.jetbrains.kotlinx.multik.ndarray.operations.toList
import org.jetbrains.kotlinx.multik.ndarray.operations.toMutableList

private val logger = FluentLogger.forEnclosingClass()

fun day02() {
  val table = file("day02.txt").readLines().map { it.toIntArray() }

  var safeCount = 0
  for (i in table.indices) {
    if (isSafe(table[i].toList())) {
      safeCount++
    }
  }
  logger.atInfo().log("part 1: $safeCount")

  safeCount = 0
  for (i in table.indices) {
    if (isSafe(table[i].toList())) {
      safeCount++
    } else {
      for (j in table[i].indices) {
        if (isSafe(table[i].toMutableList().also { it.removeAt(j) })) {
          safeCount++
          break
        }
      }
    }
  }
  logger.atInfo().log("part 2: $safeCount")
}

fun isSafe(arr: List<Int>): Boolean {
  val direction = arr[1] - arr[0]
  if (direction == 0) return false
  for (i in 1 until arr.size) {
    val last = arr[i - 1]
    if (!((arr[i] - last > 0 && direction > 0) || (arr[i] - last < 0 && direction < 0))) {
      return false
    }
    if (abs(arr[i] - last) > 3) return false
  }
  return true
}
