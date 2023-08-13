/*

11725번 - 트리의 부모 찾기

https://www.acmicpc.net/problem/11725

간선을 따라가며 가장 빨리 만나는 노드가 있으면 그 간선이 부모 노드와 연결된 간선이므로 BFS를 사용하면 된다.
tree는 인접 리스트를 사용했다.

*/

package baekjoon_kotlin._11000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val tree = Array(n + 1) { ArrayList<Int>() }
    repeat(n - 1) {
        val u = i()
        val v = i()
        tree[u].add(v)
        tree[v].add(u)
    }
    val answer = IntArray(n + 1)
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue += 1 to 1

    while (queue.isNotEmpty()) {
        val (p, q) = queue.removeFirst()
        if (answer[q] == 0) {
            answer[q] = p
            tree[q].forEach { queue.add(q to it) }
        }
    }
    val sb = StringBuilder()
    answer.slice(2..n).forEach { sb.appendLine(it) }
    print(sb)
}

/*

*/