package baekjoon_kotlin._2000

import java.util.Scanner

fun main() {
    val a = Scanner(System.`in`).nextInt()
    for (i in 1 .. 9){
        println("$a * $i = ${a*i}")
    }
}