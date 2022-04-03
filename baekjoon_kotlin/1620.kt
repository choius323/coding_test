/*

1620번 - 나는야 포켓몬 마스터 이다솜
https://www.acmicpc.net/problem/1620

인덱스로 검색할 때는 배열을 써도 시간 복잡도는 O(1)이지만 이름으로 검색하면 indexOf()가 O(n)이므로 HashMap을 사용해야 한다.

 */

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val name = HashMap<String, Int>()
    val number = HashMap<Int, String>()
    for (i in 1..n) {
        val str = br.readLine()
        number[i] = str
        name[str] = i
    }

    for (i in 1..m) {
        val input = br.readLine()
        if (input[0].isDigit()) {
            sb.append(number[input.toInt()] + "\n")
        } else {
            sb.appendLine(name[input])
        }
    }
    println(sb)
}