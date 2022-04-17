/*

4153번 - 직각삼각형
https://www.acmicpc.net/problem/4153

when은 다른 언어의 switch/case와 비슷한 역할이다.
다른 점은 break를 사용하지 않아도 되고 0, 1 -> 처럼 여러 조건을 한 번에 호출 할 수 있다.

 */

package baekjoon_kotlin

import kotlin.math.pow

fun main() {
    while (true) {
        val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
            break
        } else {
            var max = 0
            var min1 = 0
            var min2 = 0
            when (arr.indexOf(arr.maxOrNull()!!)) {
                0 -> {
                    max = arr[0]; min1 = arr[1]; min2 = arr[2]
                }
                1 -> {
                    max = arr[1]; min1 = arr[0]; min2 = arr[2]
                }
                2 -> {
                    max = arr[2]; min1 = arr[0]; min2 = arr[1]
                }
            }
            println(if (pow(max) == pow(min1, min2)) "right" else "wrong")
        }
    }
}

private fun pow(a: Int, b: Int = 0) = a.toDouble().pow(2) + b.toDouble().pow(2)