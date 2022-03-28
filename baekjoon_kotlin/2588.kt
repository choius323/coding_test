package baekjoon_kotlin

import java.util.Scanner as u

fun main() {
    val s = u(System.`in`)
    val a = s.nextInt()
    val b = s.next()
    b.reversed().forEach { println(a*(it - '0')) }
    println(a*b.toInt())
}