package baekjoon_kotlin._25000/*

25426번 - 일차함수들
https://www.acmicpc.net/problem/25426

함수 f(x) = a_i*x + b_i이지만 x는 항상 i와 같다.
따라서 값이 최대가 되려면 a_i가 클수록 마지막에 있어야 한다.
a를 기준으로 오름차순 정렬을 하고 모두 더하면 답이 나온다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class AB(val a: Long, val b: Long)

    val r = { nextToken();nval.toLong() }
    val nums = List(r().toInt()) { AB(r(), r()) }.sortedBy { it.a }
    var sum = 0L
    nums.forEachIndexed { i, (a, b) -> sum += a * (i + 1).toLong() + b }
    print(sum)
}

/*

*/