/*

1874번 - 스택 수열
https://www.acmicpc.net/problem/1874

스택의 기본적인 연산 과정이다.
어차피 +와 -를 매번 출력해줘야 하므로 직접 계산하면 된다.

연산량이 적어서 그런지 시간은 큰 차이 없다.
ArrayDeque(344ms) < Stack(388ms) < MutableList(320ms)

 */

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val arr = Array(br.readLine().toInt()) { br.readLine().toInt() }
//    val stack = mutableListOf<Int>()
//    val stack = Stack<Int>()
    val stack = ArrayDeque<Int>()
    var i = 1
    arr.forEach {
        while (i <= arr.size + 1) {
            if (stack.isNotEmpty() && stack.last() == it) {
//                stack.removeAt(stack.size - 1) // MutableList
//                stack.pop() // Stack
                stack.removeLast()  // ArrayDeque
                sb.append("-\n")
                break
            } else {
                stack.add(i)
                sb.append("+\n")
                i += 1
            }
        }
    }
    if (stack.isNotEmpty()) {
        println("NO")
    } else{
        println(sb)
    }
}