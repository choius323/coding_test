/*

25187번 - 고인물이 싫어요
https://www.acmicpc.net/problem/25187

Union-Find 사용을 원하는 문제였지만 BFS와 DP를 활용해서 풀었다.
나중에 다시 풀어야겠다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken(); return nval.toInt()
    }

    val n = i()
    val m = i()
    val q = i()
    val tank = Array(n) { HashSet<Int>() }
    val fresh = IntArray(n) { if (i() == 1) 1 else -1 }
    val dp = IntArray(n) { -1 }
    repeat(m) {
        val u = i() - 1
        val v = i() - 1
        if (v !in tank[u]) tank[u] += v
        if (u !in tank[v]) tank[v] += u
    }
    val sb = StringBuilder()
    repeat(q) {
        val k = i() - 1
        if (dp[k] == -1) {
            val visited = HashSet<Int>()
            val queue = ArrayDeque<Int>()
            var new = fresh[k]
            queue.add(k)
            visited += k
            while (queue.isNotEmpty()) {
                val i = queue.removeFirst()
                for (t in tank[i]) {
                    if (t !in visited) {
                        new += fresh[t]
                        queue.add(t)
                        visited += t
                    }
                }
            }
            new = if (new > 0) 1 else 0
            for (v in visited) dp[v] = new
        }
        sb.appendLine(dp[k])
    }
    print(sb)
}
/*

*/