package goorm_kotlin.week3


import java.util.*

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken(); nval.toInt() }
    val n = r()
    val negative = PriorityQueue<Int>() { o1, o2 -> o2 - o1 }
    val positive = PriorityQueue<Int>()
    repeat(n) {
        val num = r()
        (if (num < 0) negative else positive).add(num)
    }
    var answer = 0
    while (negative.isNotEmpty() || positive.isNotEmpty()) {
        if (negative.isEmpty()) answer += positive.poll()
        else if (positive.isEmpty()) answer += negative.poll()
        else if (-negative.peek() == positive.peek()) {
            negative.poll()
            positive.poll()
        } else if (-negative.peek() < positive.peek()) answer += negative.poll()
        else answer += positive.poll()
    }
    println(answer)
}