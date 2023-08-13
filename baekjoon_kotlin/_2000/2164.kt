/*

2164번 - 카드2
https://www.acmicpc.net/problem/2164

ArrayDeque나 LinkedList를 사용하면 시간 초과 없이 해결 가능하다

 */

package baekjoon_kotlin._2000

fun main() {
    val n = readLine()!!.toInt()
    val deque = ArrayDeque((1..n).toList())
    while (deque.size > 1){
        deque.removeAt(0)
        deque.add(deque.removeAt(0))
    }
    println(deque[0])
}