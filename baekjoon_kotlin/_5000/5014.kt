/*

5014번 - 스타트링크
https://www.acmicpc.net/problem/5014

bfs를 사용해서 풀면 된다.
repeat을 사용해서 큐에 넣었던 값들을 다 사용한 후 count를 1 더하는 방식을 반복한다.

*/

package baekjoon_kotlin._5000

fun main() = System.`in`.bufferedReader().run {
    val (f, s, g, u, d) = readLine().split(" ").map { it.toInt() }
    val floor = BooleanArray(f + 1)
    val queue = ArrayDeque<Int>()
    queue.add(s)
    floor[s] = true
    var count = 0
    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val q = queue.removeFirst()
            if (q == g) return print(count)
            if (q + u <= f && !floor[q + u]) {
                queue.add(q + u)
                floor[q + u] = true
            }
            if (1 <= q - d && !floor[q - d]) {
                queue.add(q - d)
                floor[q - d] = true
            }
        }
        count += 1
    }
    print("use the stairs")
}

/*

*/