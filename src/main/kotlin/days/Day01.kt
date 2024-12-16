package com.hopskipnfall.adventofcode2024.days

import com.google.common.flogger.FluentLogger
import kotlin.math.abs
import org.jetbrains.kotlinx.multik.ndarray.data.D2
import org.jetbrains.kotlinx.multik.ndarray.data.NDArray
import org.jetbrains.kotlinx.multik.ndarray.data.get
import org.jetbrains.kotlinx.multik.ndarray.operations.forEach
import org.jetbrains.kotlinx.multik.ndarray.operations.sorted

private val logger = FluentLogger.forEnclosingClass()

fun day01() {
  val table: NDArray<Int, D2> = readTable("day01.txt").transpose()

  var diff = 0

  val col1 = table[0].sorted()
  val col2 = table[1].sorted()
  for (i in col1.indices) {
    diff += abs(col1[i] - col2[i])
  }
  logger.atInfo().log("Part 1: %d", diff)

  val col2Counts = mutableMapOf<Int, Int>()
  col2.forEach { col2Counts[it] = col2Counts.getOrDefault(it, 0) + 1 }

  var part2 = 0
  col1.forEach { part2 += it * col2Counts.getOrDefault(it, 0) }
  logger.atInfo().log("Part 2: %d", part2)
}
