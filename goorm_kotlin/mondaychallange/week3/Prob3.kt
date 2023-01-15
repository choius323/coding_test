package goorm_kotlin.mondaychallange.week3

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken(); nval.toInt() }
    val n = r()
    val m = r()
    val k = r()
    val bridges = List(n) { mutableListOf<Int>() }
    repeat(m) {
        val u = r() - 1
        val v = r() - 1
        bridges[u] += v
        bridges[v] += u
    }

    val queue = ArrayDeque<Int>()
    val visited = BooleanArray(n)
    var count = 0
    fun visit(p: Int) {
        queue.add(p)
        visited[p] = true
    }

    visit(0)
    while (count <= k) {
        repeat(queue.size) {
            val visit = queue.removeFirst()
            if (visit == n - 1) return@run print("YES")
            for (next in bridges[visit]) {
                if (visited[next].not()) visit(next)
            }
        }
        count++
    }
    print("NO")
}