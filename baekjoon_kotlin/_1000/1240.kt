/*

1240번 - 노드사이의 거리
https://www.acmicpc.net/problem/1240

여러 방법을 사용해서 풀어봤다.
우선 가장 쉽게 구현할 수 있는 플로이드 와샬로 풀었다.
확실히 메모리는 적지만 시간이 다른 풀이보다 2~5배까지 늘어났다.

2번째 풀이는 BFS를 이용해서 탐색하고 HashMap을 이용해서 트리의 인접 리스트를 만들었다.
3번째 풀이는 BFS를 이용해서 탐색하고 ArrayList를 이용해서 트리의 인접 리스트를 만들었다.

3번째는 filter를 사용해서 그랬는지 2번째보다 더 느렸다.

*/

package baekjoon_kotlin._1000

//1. BFS와 ArrayList사용
fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Node(val v: Int, val d: Int)

    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val m = i()
    val tree = Array(n + 1) { ArrayList<Node>() }
    repeat(n - 1) {
        val u = i()
        val v = i()
        val d = i()
        tree[u].add(Node(v, d))
        tree[v].add(Node(u, d))
    }

    fun bfs(start: Int, goal: Int): Int {
        val queue = ArrayDeque<Node>()
        queue.add(Node(start, 0))
        val visited = BooleanArray(n + 1)
        visited[start] = true
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val node = queue.removeFirst()
                if (node.v == goal) return node.d
                tree[node.v].filter { !visited[it.v] }.forEach { (v, d) ->
                    queue.add(Node(v, d + node.d))
                    visited[v] = true
                }
            }
        }
        return -1
    }

    val sb = StringBuilder()
    repeat(m) {
        sb.appendLine(bfs(i(), i()))
    }
    print(sb)
}

//2. BFS와 HashMap 사용
//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    data class Node(val num: Int, val dist: Int)
//
//    fun i(): Int {
//        nextToken()
//        return nval.toInt()
//    }
//
//    val n = i()
//    val m = i()
//    val tree = Array(n + 1) { HashMap<Int, Int>() }
//    repeat(n - 1) {
//        val u = i()
//        val v = i()
//        val d = i()
//        tree[u] += v to d
//        tree[v] += u to d
//    }
//
//    fun bfs(u: Int, v: Int): Int {
//        val queue = ArrayDeque<Node>()
//        queue.add(Node(u, 0))
//        val visited = BooleanArray(n + 1)
//        visited[u] = true
//        while (queue.isNotEmpty()) {
//            repeat(queue.size) {
//                val (num, dist) = queue.removeFirst()
//                if (num == v) return dist
//                tree[num].forEach { (n, d) ->
//                    if (!visited[n]) {
//                        queue.add(Node(n, d + dist))
//                        visited[n] = true
//                    }
//                }
//            }
//        }
//        return -1
//    }
//
//    val sb = StringBuilder()
//    repeat(m) {
//        sb.appendLine(bfs(i(), i()))
//    }
//    print(sb)
//}

//3. 플로이드 와샬 사용
//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    fun i(): Int {
//        nextToken()
//        return nval.toInt()
//    }
//
//    val n = i()
//    val m = i()
//    val dist = Array(n + 1) { IntArray(n + 1) { 10000000 } }
//    repeat(n - 1) {
//        val u = i()
//        val v = i()
//        val d = i()
//        dist[u][v] = d
//        dist[v][u] = d
//    }
//
//    for (k in 1..n) for (a in 1..n) for (b in 1..n) {
//        if (dist[a][b] > dist[a][k] + dist[k][b])
//            dist[a][b] = dist[a][k] + dist[k][b]
//    }
//
//    val sb = StringBuilder()
//    repeat(m) {
//        sb.appendLine(dist[i()][i()])
//    }
//    print(sb)
//}

/*
5 6
2 1 2
4 3 2
1 4 3
3 5 2
1 2
1 3
3 2
4 3
2 5
1 5

2
5
7
2
9
7
*/