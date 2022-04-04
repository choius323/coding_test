/*

1697번 - 숨바꼭질
https://www.acmicpc.net/problem/1697

bfs를 사용해서 원하는 값을 찾았을 때 반복문을 종료했다.
방문했던 곳은 HashMap의 in을 사용해 확인했고 queue는 ArrayDeque를 사용해 삽입, 삭제를 빠르게 했다.

 */

package baekjoon_kotlin

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    if (k <= n) {
        println(n - k)
    } else {
        val visited = hashMapOf(n - 1 to 1, n + 1 to 1, n * 2 to 1)
        val queue = ArrayDeque<Array<Int>>()
        queue.addAll(arrayOf(arrayOf(n - 1, 1), arrayOf(n + 1, 1), arrayOf(n * 2, 1)))
        while (true) {
            val (n2, count) = queue.removeAt(0)
            if (k == n2) {
                println(count)
                break
            } else {
                if (n2 <= k * 3) {
                    for (exp in intArrayOf(n2 - 1, n2 + 1, n2 * 2)) {
                        if (exp !in visited.keys) {
                            queue.add(arrayOf(exp, count + 1))
                            visited[exp] = count
                        }
                    }
                }
            }
        }
    }
}