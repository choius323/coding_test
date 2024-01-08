package baekjoon_kotlin._20000

/*

20040번 - 사이클 게임
https://www.acmicpc.net/problem/20040
분류 : 자료 구조, 분리 집합

서로 다른 노드 a, b를 이을 때 부모가 같다면 사이클이 발생하게 된다.
union-find를 그대로 사용하면 해결할 수 있다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val roots = IntArray(n) { it }

    fun find(a: Int): Int {
        if (roots[a] != a) {
            roots[a] = find(roots[a])
        }
        return roots[a]
    }

    fun union(a: Int, b: Int): Boolean {
        val aRoot = find(a)
        val bRoot = find(b)
        if (aRoot == bRoot) return false

        roots[bRoot] = aRoot
        return true
    }

    repeat(m) {
        val a = r()
        val b = r()
        if (union(a, b).not()) {
            return print(it + 1)
        }
    }
    print(0)
}

/*

*/