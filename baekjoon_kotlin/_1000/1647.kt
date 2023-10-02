package baekjoon_kotlin._1000

/*

1647번 - 도시 분할 계획
https://www.acmicpc.net/problem/1647
분류 : 그래프 이론, 최소 스패닝 트리

최소 비용으로 모든 마을을 연결해야 되기 때문에 크루스칼 알고리즘을 사용해 MST를 구했다.
마을을 2개의 그룹으로 나누면서 서로 연결하기 위해선 MST에서 가장 비용이 큰 간선을 제외하면 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Edge(val u: Int, val v: Int, val dist: Int)

    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val parents = IntArray(n) { it }

    fun find(a: Int): Int = if (parents[a] == a) {
        a
    } else {
        parents[a] = find(parents[a])
        parents[a]
    }

    fun union(a: Int, b: Int): Boolean {
        val pa = find(a)
        val pb = find(b)

        if (pa == pb) {
            return false
        }
        parents[pa] = pb
        return true
    }

    val pq = java.util.PriorityQueue<Edge>(compareBy(Edge::dist))
    repeat(m) {
        val u = r() - 1
        val v = r() - 1
        val dist = r()
        pq.add(Edge(u, v, dist))
    }

    var count = 0
    var sum = 0
    while (pq.isNotEmpty() && count < n - 2) {
        val edge = pq.poll()
        if (union(edge.u, edge.v)) {
            count++
            sum += edge.dist
        }
    }
    print(sum)
}

/*

*/