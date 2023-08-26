package baekjoon_kotlin._28000

/*

28278번 - 스택 2
https://www.acmicpc.net/problem/28278
분류 : 자료 구조, 스택

ArrayDeque을 Stack으로 사용하며 입출력을 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val deque = ArrayDeque<Int>()
    val sb = StringBuilder()
    repeat(r()) {
        sb.appendLine(
            when (r()) {
                2 -> deque.removeLastOrNull() ?: -1
                3 -> deque.size
                4 -> if (deque.isEmpty()) 1 else 0
                5 -> deque.lastOrNull() ?: -1
                else -> {
                    deque += r()
                    return@repeat
                }
            }
        )
    }
    print(sb)
}