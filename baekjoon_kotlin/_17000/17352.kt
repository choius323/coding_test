package baekjoon_kotlin._17000

/*

17352번 - 여러분의 다리가 되어 드리겠습니다!
https://www.acmicpc.net/problem/17352
분류 : 자료 구조, 그래프 이론, 그래프 탐색, 분리 집합

BFS나 union-find를 사용하면 될 것 같다.
union-find로 연결된 각 섬을 저장하고, 1번 섬과 연결되지 않은 섬을 찾아서 출력했다.
어느 한 섬은 반드시 최소 한개의 다른 섬과 이어져있지 않다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val parents = IntArray(n) { it }

    fun find(num: Int): Int {
        if (parents[num] == num) return num
        else {
            val parent = find(parents[num])
            parents[num] = parent
            return parent
        }
    }

    fun union(num1: Int, num2: Int) {
        val parent1 = find(num1)
        val parent2 = find(num2)

        if (parent1 == parent2) return
        parents[parent1] = parent2
    }

    repeat(n - 2) {
        union(r() - 1, r() - 1)
    }
    for (i in 1 until n) {
        if (find(0) != find(i)) {
            return print("1 ${i + 1}")
        }
    }
}

/*

*/