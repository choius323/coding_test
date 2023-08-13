/*

13549번 - 숨바꼭질 3
https://www.acmicpc.net/problem/13549

0-1 BFS를 활용하는 문제이다.
0-1 BFS는 간선의 가중치가 0과 1밖에 없는 상황에서 최단 경로를 찾을 때 사용하는 알고리즘이고 이 문제에선 가중치가 텔레포트는 0, -1과 +1은 1이다.
따라서 위의 알고리즘을 활용할 수 있고 addFirst를 사용한 코드가 그 예시이다.

기본적인 BFS로 쓸 수 있지만 텔레포트를 사용할 때는 count가 늘어나지 않는 걸 주의해야 한다.

*/

package baekjoon_kotlin._13000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val p: Int, val c: Int)

    nextToken()
    val n = nval.toInt()
    nextToken()
    val k = nval.toInt()
    if (n >= k) print(n - k)
    else {
        val vis = BooleanArray(k * 6 / 5 + 1)
        val que = ArrayDeque<Pos>()
        que.add(Pos(n, 0))
        vis[n] = true
        while (que.isNotEmpty()) {
            val (p, c) = que.removeFirst()
            if (p == k) {
                print(c)
                return@run
            }
            if (p * 2 <= k * 6 / 5 && !vis[p * 2]) { // 가중치 0
                que.addFirst(Pos(p * 2, c))
                vis[p * 2] = true
            }
            for (np in intArrayOf(p - 1, p + 1)) { // 가중치 1. for문을 쓰지 않고 따로 쓰면 더 빠를 수 있다. 또 listOf를 쓰면 훨씬 느리다.
                if (np in 0..k * 6 / 5 && !vis[np]) {
                    que.add(Pos(np, c + 1))
                    vis[np] = true
                }
            }
        }
    }
}

//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    fun i(): Int {
//        nextToken()
//        return nval.toInt()
//    }
//
//    var n = i()
//    val k = i()
//    if (n >= k) print(n - k)
//    else {
//        val visited = BooleanArray(150001)
//        val queue = ArrayDeque<Int>()
//        if (n in 0..k * 3 / 2 && !visited[n]) {
//            do {
//                queue.add(n)
//                visited[n] = true
//                n *= 2
//            } while (n in 0..k * 3 / 2 && !visited[n])
//        }
//        var count = 0
//        whileLoop@ while (queue.isNotEmpty()) {
//            val size = queue.size
//            for (i in 1..size) {
//                val q = queue.removeFirst()
//                if (q == k) break@whileLoop
//                for (moved in intArrayOf(q - 1, q + 1)) {
//                    n = moved
//                    if (n in 0..k * 3 / 2 && !visited[n]) {
//                        do {
//                            queue.add(n)
//                            visited[n] = true
//                            n *= 2
//                        } while (n in 0..k * 3 / 2 && !visited[n])
//                    }
//                }
//            }
//            count += 1
//        }
//        print(count)
//    }
//}

/*

*/