package baekjoon_kotlin._1000

/*

1595번 - 북쪽나라의 도로
https://www.acmicpc.net/problem/1595
분류 : 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색

트리에서 서로 가장 먼 노드 2개를 찾는 방법은 한 노드에서 가장 먼 노드를 찾은 뒤, 그 노드에서 가장 먼 노드를 찾는 것이다.
가장 먼 노드를 찾을 때는 다익스트라를 사용했다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Edge(val v: Int, val dist: Int)

    val r = {
        if (nextToken() == -1) -1 // EOF
        else nval.toInt()
    }
    val tree = Array(10001) { mutableListOf<Edge>() }
    var n = 0
    while (true) {
        val u = r()
        if (u == -1) break
        val v = r()
        n = maxOf(n, u, v)
        val dist = r()
        tree[u].add(Edge(v, dist))
        tree[v].add(Edge(u, dist))
    }
    n++

    fun dijkstra(startIdx: Int): Pair<Int, Int> {
        val dists = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = java.util.PriorityQueue(compareBy(Edge::dist))
        dists[startIdx] = 0
        pq.add(Edge(startIdx, 0))
        while (pq.isNotEmpty()) {
            val now = pq.remove()
            for (edge in tree[now.v]) {
                val nDist = dists[now.v] + edge.dist
                if (dists[edge.v] > nDist) {
                    dists[edge.v] = nDist
                    pq.add(Edge(edge.v, nDist))
                }
            }
        }
        dists[0] = -1
        var maxIdx = 0
        for (i in 1..n) {
            if (dists[i] != Int.MAX_VALUE && dists[i] > dists[maxIdx]) {
                maxIdx = i
            }
        }
        return maxIdx to dists[maxIdx]
    }

    val index = dijkstra(1).first
    print(dijkstra(index).second)
}

/*

*/