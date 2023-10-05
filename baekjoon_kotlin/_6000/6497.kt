package baekjoon_kotlin._6000

/*

6497번 - 전력난
https://www.acmicpc.net/problem/6497
분류 : 그래프 이론, 최소 스패닝 트리

최소한의 금액으로 모든 마을을 연결해야 하므로 최소 스패닝 트리(MST)를 만드는 문제이다.
우선 모든 간선을 가중치를 기준으로 오름차순 정렬한다.
그 후에 Union-Find를 사용해 간선을 선택하며 모든 마을을 연결한다.
선택한 간선이 마을의 수 - 1이 되면 모든 마을이 연결된 것이므로 그때의 가중치 합을 구한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Edge(val u: Int, val v: Int, val weight: Int)

    val r = { nextToken();nval.toInt() }
    while (true) {
        val m = r()
        if (m == 0) return
        val n = r()
        val parents = IntArray(m) { it }
        val edges = Array(n) { Edge(r(), r(), r()) }.sortedArrayWith(compareBy { it.weight })

        fun findRoot(u: Int): Int = if (parents[u] != u) findRoot(parents[u]) else u

        fun unionFind(u: Int, v: Int): Boolean {
            val root1 = findRoot(u)
            val root2 = findRoot(v)

            if (root1 != root2) {
                parents[root2] = root1
            }
            return root1 != root2
        }

        var count = 0
        var sumElect = 0
        for ((u, v, dist) in edges) {
            if (unionFind(u, v)) {
                count++
                sumElect += dist
            }
            if (count == m - 1) break
        }
        println(edges.sumOf { it.weight } - sumElect)
    }
}

/*

*/