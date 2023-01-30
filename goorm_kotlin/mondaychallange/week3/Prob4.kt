package mondaychallange.week3

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run { //미해결
    val r = { nextToken();nval.toInt() }
    val n = r()
    var answerList = listOf<Int>()
    val channels = List(n + 1) { mutableListOf<Int>() }
    repeat(n) {
        val u = r()
        val v = r()
        channels[u] += v
        channels[v] += u
    }
    var visited = mutableListOf<Boolean>()

    fun dfs(path: List<Int>) {
        for (next in channels[path.last()]) {
            if (visited[next].not()) {
                visited[next] = true
                dfs(path + next)
            } else {
                val startIndex = path.indexOf(next)
                if (answerList.size < path.size - startIndex && path.size > 2) {
                    answerList = (path + next).slice(startIndex..path.lastIndex)
                    print("${answerList.size}\n${answerList.sorted().joinToString(" ")}")
                    kotlin.system.exitProcess(0)
                }
            }
        }
    }

    for (i in 1..n) {
        visited = MutableList(n + 1) { false }
        visited[i] = true
        dfs(listOf(i))
    }

    print("${answerList.size}\n${answerList.sorted().joinToString(" ")}")
}

/*

5
5 2
2 4
4 3
3 1
1 5

 */