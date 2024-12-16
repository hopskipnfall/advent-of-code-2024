package com.hopskipnfall.adventofcode2024.days

import java.io.File
import org.jetbrains.kotlinx.multik.api.mk
import org.jetbrains.kotlinx.multik.api.ndarray
import org.jetbrains.kotlinx.multik.api.zeros
import org.jetbrains.kotlinx.multik.ndarray.data.D1Array
import org.jetbrains.kotlinx.multik.ndarray.data.D2
import org.jetbrains.kotlinx.multik.ndarray.data.NDArray
import org.jetbrains.kotlinx.multik.ndarray.data.set

fun file(fileName: String) = File("./src/main/resources/$fileName")

fun String.toIntArray(separator: Regex = Regex("\\s+")): D1Array<Int> {
  val parts = split(separator)
  val array = mk.zeros<Int>(parts.size)
  parts.forEachIndexed { index, s -> array[index] = s.toInt() }
  return array
}

fun readTable(
  fileName: String,
  separator: Regex = Regex("\\s+"),
  overrideFileWith: String? = null
): NDArray<Int, D2> {
  val lines =
    if (overrideFileWith != null) overrideFileWith.trim().lines() else file(fileName).readLines()
  val array = mk.zeros<Int>(lines.size, lines.first().split(separator).size)
  lines.forEachIndexed { index, s ->
    array[index] = mk.ndarray(s.split(separator).map(String::toInt))
  }
  return array
}
