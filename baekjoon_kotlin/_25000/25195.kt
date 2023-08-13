/*

25195번 - Yes or yes
https://www.acmicpc.net/problem/25195

bfs를 사용해서 풀었지만 dfs를 사용해도 된다.
사이클이 없고, 간선이 양방향이 아니기 때문에 visited 배열을 만들 필요가 없다.
출발지에 팬이 있을 때를 주의하면 된다.

*/

package baekjoon_kotlin._25000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val m = i()
    val tree = Array(n + 1) { HashSet<Int>() }
    repeat(m) { tree[i()] += i() }
    val fan = HashSet<Int>()
    repeat(i()) { fan.add(i()) }

    val queue = ArrayDeque<Int>()
    val visited = BooleanArray(n + 1)
    queue.add(1)
    visited[1] = true
    var answer = 1 in fan

    if (!answer) {
        answer = true
        while (queue.isNotEmpty()) {
            val q = queue.removeFirst()
            if (tree[q].size == 0) {
                answer = false
                break
            }
            for (node in tree[q]) {
                if (!visited[node] && node !in fan) {
                    queue.add(node)
                    visited[node] = true
                }
            }
        }
    }
    print(if (answer) "Yes" else "yes")
}

/*

*/