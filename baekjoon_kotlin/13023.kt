/*

13023번 - ABCDE
https://www.acmicpc.net/problem/13023

DFS를 활용해 친구가 연속으로 5명이 연결되는지 확인한다.
A-B-C-D-E 순으로 연결돼있을 때 B부터 DFS를 시작하면 B-C와 B-C-D-E로 나뉘어서 확인이 불가능하지만 A나 E부터 탐색하면 5명을 확인 가능하다.
따라서 각각 사람마다 DFS를 실행하며 5명이 연속으로 친구가 되는지 확인한다.


*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val visit = BooleanArray(n)
    val graph = Array(n) { ArrayList<Int>() }
    repeat(r()) {
        val u = r()
        val v = r()
        graph[u] += v
        graph[v] += u
    }

    fun dfs(node: Int, count: Int): Boolean {
        if (count == 5) return true
        for (next in graph[node])
            if (!visit[next]) {
                visit[next] = true
                if (dfs(next, count + 1)) return true
                visit[next] = false
            }
        return false
    }

    for (i in 0 until n) {
        visit[i] = true
        if (dfs(i, 1)) return print(1)
        visit[i] = false
    }
    print(0)
}

/*

*/