/*

6416번 - 트리인가?
https://www.acmicpc.net/problem/6416

3가지 경우의 수로 나눠서 트리를 구분했다.
1. 같은 정점을 중복으로 방문하면 트리가 아니다.
2. 루트 노드가 여러개이면 트리가 아니다.
3. 이 외에는 모두 트리이다.(정점이 0개인 경우 포함)
그래프를 탐색하는 방법은 BFS를 사용했고 모든 정점에 대해 BFS를 사용했다.
루트는 모든 정점을 set에 넣고 탐색하면서 나온 자식 노드를 지워서 남은 노드를 루트로 판단했다.

*/

package baekjoon_kotlin._6000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val graph = HashMap<Int, ArrayList<Int>>()
    val visited = BooleanArray(999)
    val queue = ArrayDeque<Int>()
    val root = HashSet<Int>()
    var k = 0
    val sb = StringBuilder()
    case@ while (true) {
        root.clear()
        k += 1
        graph.clear()
        while (true) {
            val u = i()
            val v = i()
            if (u == 0) break
            if (u == -1) return print(sb)
            root += u
            graph.getOrPut(u) { ArrayList() }.add(v)
        }

        for (key in graph.keys) {
            visited.fill(false)
            visited[key] = true
            queue.clear()
            queue.add(key)
            while (queue.isNotEmpty()) {
                val q = queue.removeFirst()
                if (q in graph.keys) for (next in graph[q]!!) {
                    if (visited[next]) {
                        sb.appendLine("Case $k is not a tree.")
                        continue@case
                    } else {
                        root -= next
                        queue.add(next)
                        visited[next] = true
                    }
                }
            }
        }
        sb.appendLine("Case $k is ${if (graph.size == 0 || root.size == 1) "" else "not "}a tree.")
    }
}

/*
6 8  5 3  5 2  6 4
5 6  0 0

8 1  7 3  6 2  8 9  7 5
7 4  7 8  7 6  0 0

3 8  6 8  6 4
5 3  5 6  5 2  0 0

1 2  2 3  4 5  0 0

-1 -1
*/