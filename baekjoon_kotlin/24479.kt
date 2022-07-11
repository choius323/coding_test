/*

24479번 - 알고리즘 수업 - 깊이 우선 탐색 1
https://www.acmicpc.net/problem/24479

기본적인 그래프의 DFS 방식 탐색이다.
visited에 몇 번째 방문인지 갱신하면 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val m = i()
    val r = i()
    val graph = Array(n + 1) { ArrayList<Int>() }
    repeat(m) {
        val a = i()
        val b = i()
        graph[a].add(b)
        graph[b].add(a)
    }

    val visited = IntArray(n + 1)
    var c = 1
    fun dfs(u: Int) {
        visited[u] = c
        c++
        for (v in graph[u].sorted()) {
            if (visited[v] == 0) {
                visited[v] = c
                dfs(v)
            }
        }
    }
    dfs(r)
    val sb = StringBuilder()
    for (i in 1..n) sb.appendLine(visited[i])
    print(sb)
//    print(visited.slice(1..n).joinToString("\n"))
}

/*

*/