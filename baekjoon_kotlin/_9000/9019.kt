/*

9019번 - DSLR
https://www.acmicpc.net/problem/9019

문제에서는 0001처럼 숨겨진 0을 포함해야 해서 문자열로 저장해야 하는 것처럼 보일 수 있지만 그럴 필요는 없다.
특히 String 객체는 Int에 비해서 처리가 느리기 때문에 Int로 저장하는 것이 좋다.
또, 중복 탐색을 제거할 때 가능한 숫자는 0~9999이므로 크기가 10000인 배열을 사용하면 된다.

DSLR에 해당하는 값을 함수로 호출해도 되지만 몇개 되지 않기 때문에 시간을 위해서 직접 작성하는 것이 더 빠르다.
Pair를 호출할 때는 Pair(a,b)도 되지만 a to b도 가능하다.
BFS에서 Queue에 값을 넣을 때는 반드시 visited에도 값을 넣어주도록 하자.

*/

package baekjoon_kotlin._9000

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val (num, goal) = readLine().split(" ").map { it.toInt() }
        val visited = BooleanArray(10000)
        val queue = ArrayDeque<Pair<Int,String>>()
        visited[num] = true
        queue.add(num to "")

        while (queue.isNotEmpty()) {
            val pair = queue.removeFirst()
            if (pair.first == goal) {
                sb.append(pair.second)
                break
            } else {
                val newN = pair.first
                val str = pair.second
                var n = newN * 2 % 10000
                if (!visited[n]) {
                    queue.add(n to str+"D")
                    visited[n] = true
                }
                n = if (newN == 0) 9999 else newN - 1
                if (!visited[n]) {
                    queue.add(n to str+"S")
                    visited[n] = true
                }
                n = newN % 1000 * 10 + newN / 1000
                if (!visited[n]) {
                    queue.add(n to str+"L")
                    visited[n] = true
                }
                n = newN % 10 * 1000 + newN / 10
                if (!visited[n]) {
                    queue.add(n to str+"R")
                    visited[n] = true
                }
            }
        }
        sb.append("\n")
    }
    print(sb)
}

// DSLR
//private fun command(newNum: Int, c: Int): Int {
//    return when (c) {
//        0 -> newNum * 2 % 10000
//        1 -> if (newNum == 0) 9999 else newNum - 1
//        2 -> newNum % 1000 * 10 + newNum / 1000
//        3 -> newNum % 10 * 1000 + newNum / 10
//        else -> Int.MAX_VALUE
//    }
//}

/*
4
1234 3412
1000 1
1 16
0 9979

LL
L
DDDD
SDSL, SSSL
 */