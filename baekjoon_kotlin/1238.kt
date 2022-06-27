/*

1238번 - 파티
https://www.acmicpc.net/problem/1238

다익스트라를 사용해서 왕복 거리를 구하는 문제이다.
2가지 방법으로 풀어봤는데 처음은 모든 정점에서 다익스트라를 사용하는 것이다.
시간 복잡도는 O(n*mlogm)이고 메모리도 모든 다익스트라에서 나온 거리를 저장해야 하기 때문에 n*n배열이 필요하다.

두 번째는 다익스트라를 2번 사용하는 것이다.
구해야 하는 거리는 x에서 출발한 거리와 x까지 가는데 걸리는 거리이다.
x에서 출발한 것은 평범한 다익스트라이고 x까지 걸리는 것은 모든 간선을 거꾸로 한 뒤에 x에서 다익스트라를 하면 된다.
2->1, 3->1인 간선이 있을 때 그 간선을 뒤집으면 1->2, 1->3이 된다.
이 때 1에서 다익스트라를 사용하면 2와 3에서 출발했을 때 1까지의 거리가 나온다.

*/

package baekjoon_kotlin

// 다익스트라 2번 사용
fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Road(val v: Int, val d: Int)

    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val pq = java.util.PriorityQueue<Int>()

    val n = i()
    val m = i()
    val x = i()

    fun dijkstra(dist: IntArray, road: Array<ArrayList<Road>>): IntArray {
        pq.add(x)
        dist[x] = 0
        while (pq.isNotEmpty()) {
            val q = pq.poll()
            for ((v, d) in road[q]) {
                if (dist[v] > dist[q] + d) {
                    dist[v] = dist[q] + d
                    pq.add(v)
                }
            }
        }
        return dist
    }

    val road = Array(n + 1) { ArrayList<Road>() }
    val roadRe = Array(n + 1) { ArrayList<Road>() }
    repeat(m) {
        val u = i()
        val v = i()
        val d = i()
        road[u].add(Road(v, d))
        roadRe[v].add(Road(u, d))
    }

    val dist = dijkstra(IntArray(n + 1) { 99999 }, road)
    val distRe = dijkstra(IntArray(n + 1) { 99999 }, roadRe)

    var answer = 0
    for (i in 1..n) {
        if (i != x)
            answer = maxOf(dist[i] + distRe[i], answer)
    }
    print(answer)
}

// 모든 정점에 대한 다익스트라 실행. O(n*mlogm)
//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    data class Road(val v: Int, val d: Int)
//
//    fun i(): Int {
//        nextToken()
//        return nval.toInt()
//    }
//
//    val n = i()
//    val m = i()
//    val x = i()
//    val road = Array(n + 1) { ArrayList<Road>() }
//    repeat(m) { road[i()].add(Road(i(), i())) }
//    val pq = java.util.PriorityQueue<Int>()
//    val dist = Array(n + 1) { IntArray(n + 1) { 99999 } }
//    for (u in 1..n) {
//        pq.add(u)
//        dist[u][u] = 0
//        while (pq.isNotEmpty()) {
//            val q = pq.poll()
//            for ((v, d) in road[q]) {
//                if (dist[u][v] > dist[u][q] + d) {
//                    dist[u][v] = dist[u][q] + d
//                    pq.add(v)
//                }
//            }
//        }
//    }
//    var answer = 0
//    for (i in 1..n) {
//        if (i != x)
//            answer = maxOf(dist[i][x] + dist[x][i], answer)
//    }
//    print(answer)
//}

/*

*/