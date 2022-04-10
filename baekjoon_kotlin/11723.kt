/*

11723번 - 집합
https://www.acmicpc.net/problem/11723

연산의 수가 3000000이기 때문에 탐색을 하지 않는게 좋다.
여기선 배열을 활용했지만 20칸에 1,0 두가지 값만 표현할 수 있으면 되고, 복잡한 연산이 필요한게 아니기 때문에 비트 연산자를 활용해도 된다.

*/

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    var set = IntArray(21)
    repeat(br.readLine().toInt()) {
        val input = br.readLine().split(" ")
        val n = if (input.size > 1) input[1].toInt() else 0
        when (input[0]) {
            "add" -> set[n] = 1
            "remove" -> set[n] = 0
            "check" -> sb.appendLine(set[n])
            "toggle" -> set[n] = (set[n] + 1) % 2
            "all" -> set = IntArray(21) { 1 }
            "empty" -> set = IntArray(21)
        }
    }
    print(sb)
}