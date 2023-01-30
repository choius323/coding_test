package mondaychallange.week7

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken(); nval.toInt() }
    val n = r()
    val m = r()
    val graph = List(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val u = r()
        val v = r()
        graph[u] += v
        graph[v] += u
    }
    val queue = ArrayDeque<Int>()
    val visited = MutableList(n + 1) { false }
    var count = 0
    fun visit(i: Int) {
        if (visited[i].not()) {
            queue.add(i)
            visited[i] = true
            count++
        }
    }
    visit(1)
    while (queue.isNotEmpty()) {
        val now = queue.removeFirst()
        for (next in graph[now]) {
            visit(next)
        }
    }
    print(count)
}