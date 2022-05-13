/*

1167번 - 트리의 지름
https://www.acmicpc.net/problem/1167

BFS를 2번 사용하면 된다.
1967번과 거의 동일하면 입력만 주의하면 된다.

임의의 정점 a에서 가장 멀리있는 점을 찾고 다시 그 정점에서 멀리있는 점과의 거리를 구하면 트리의 지름이 된다.
트리는 가중치가 있지만 사이클이 없기 때문에 BFS나 DFS를 사용하면 된다.

증명 참고
https://www.weeklyps.com/entry/%ED%8A%B8%EB%A6%AC%EC%9D%98-%EC%A7%80%EB%A6%84

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val v = i()
    val tree = Array(v + 1) { HashMap<Int, Int>() }
    for (i in 1..v) {
        i().also {
            while (true) {
                val b = i()
                if (b == -1) break
                tree[it] += b to i()
            }
        }
    }
    data class Node(val u: Int, val w: Int)

    var max = Node(1, 0)
    fun bfs() {
        val visited = BooleanArray(v + 1)
        val queue = ArrayDeque<Node>()
        visited[max.u] = true
        queue.add(Node(max.u, 0))

        while (queue.isNotEmpty()) {
            val q = queue.removeFirst()
            tree[q.u].forEach {
                if (!visited[it.key]) {
                    val nw = it.value + q.w
                    queue.add(Node(it.key, nw))
                    visited[it.key] = true
                    if (max.w < nw) max = Node(it.key, nw)
                }
            }
        }
    }
    bfs();bfs()
    print(max.w)
}

/*
5
1 5 1 -1
5 1 1 4 10 -1
4 3 10 5 10 -1
3 2 10 4 10 -1
2 3 10 -1
*/