package baekjoon_kotlin._10000

/*

10845번 - 큐
https://www.acmicpc.net/problem/10845

kotlin엔 단방향 큐가 없기 때문에 양방향 큐인 ArrayDeque를 사용해서 풀었다.

*/

fun main() = System.`in`.bufferedReader().run {
    val queue = ArrayDeque<Int>()
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val input = readLine().split(" ")
        sb.appendLine(
            when (input[0]) {
                "pop" -> queue.removeFirstOrNull() ?: -1
                "size" -> queue.size
                "empty" -> if (queue.isEmpty()) 1 else 0
                "front" -> queue.firstOrNull() ?: -1
                "back" -> queue.lastOrNull() ?: -1
                "push" -> {
                    queue += input[1].toInt()
                    return@repeat
                }

                else -> throw Exception()
            }
        )
    }
    print(sb)
}

/*

*/