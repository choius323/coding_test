package baekjoon_kotlin._11000

/*

11657번 - 타임머신
https://www.acmicpc.net/problem/11657
분류 : 그래프 이론, 최단 경로, 벨만–포드

음수 가중치가 있는 그래프이므로 다익스트라는 사용이 불가능하다.
시작 지점과 완전히 이어지지 않은 노드가 있는지 확인해야 하므로 거리를 계산할 때 시작 지점과의 연결을 확인한 뒤 갱신해야 한다.
또, 사이클이 발생하는지 확인하기 위해 모든 지점을 갱신한 뒤 사이클을 확인한다.
음수로 값을 계속 갱신하다 보면 양수와 다르게 같은 음수 간선을 활용해 거리가 계속 줄어들 수 있으므로 Int 범위를 넘을 수 있다.

플로이드-워셜로도 풀이가 가능하며 위와 같은 문제가 발생할 수 있으므로 유의해야 하며, 처음 그래프를 초기화 할 때 중복 경로의 간선이 있을 수 있다.

*/

// 벨만-포드
fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Edge(val start: Int, val end: Int, val dist: Long)

    val MAX = 100_000_000L
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val edges = Array(m) { Edge(r() - 1, r() - 1, r().toLong()) }

    val dists = LongArray(n) { MAX }
    dists[0] = 0
    for (count in 1..n) {
        for (edge in edges) {
            if (dists[edge.start] == MAX) continue
            val nDist = dists[edge.start] + edge.dist
            if (nDist < dists[edge.end]) {
                if (count == n) {
                    return print(-1)
                }
                dists[edge.end] = nDist
            }
        }
    }

    print(dists.slice(1 until n).map { if (it == MAX) -1 else it }.joinToString("\n"))
}

// 플로이드-워셜
fun main2() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val MAX = 100_000_000L
    val r = { nextToken();nval.toInt() }
    val n = r()
    val dists = Array(n) { LongArray(n) { MAX } }
    repeat(n) {
        dists[it][it] = 0
    }
    repeat(r()) {
        val start = r() - 1
        val end = r() - 1
        val dist = r().toLong()
        dists[start][end] = minOf(dists[start][end], dist)
    }
    for (b in 0 until n) for (a in 0 until n) for (c in 0 until n) {
        if (dists[a][b] == MAX || dists[b][c] == MAX) continue
        dists[a][c] = minOf(dists[a][c], dists[a][b] + dists[b][c])
    }
    for (i in 0 until n) {
        if (dists[0][i] != MAX && dists[i][i] < 0) return print(-1)
    }
    print(dists[0].slice(1 until n).map { if (it == MAX) -1 else it }.joinToString("\n"))
}

/*

*/