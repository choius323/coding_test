/*

1753번 - 최단경로
https://www.acmicpc.net/problem/1753

인접 리스트와 우선순위 큐를 사용해서 다익스트라 알고리즘을 구현했다.
인접 행렬을 사용하면 V^2 크기의 배열이 필요한데, 여기선 최대 20000이기 때문에 메모리 초과가 발생해서 인접 리스트를 사용해야 한다.
TreeMap은 Key를 기준으로 정렬하는 기능밖에 없기 때문에 Value를 활용하기 위해 우선순위 큐를 사용했다.

*/

package baekjoon_kotlin._1000

import java.io.StreamTokenizer
import java.util.*
import kotlin.math.min

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i() = nextToken().run { nval.toInt() }
    val V = i()  // 정점의 개수
    val E = i()  // 간선의 개수
    val K = i()  // 시작 정점
    val graph = Array(V + 1) { HashMap<Int, Int>() }  // 간선 - 인접 리스트 구현. graph[시작점][중간지점] -> 거리
    val answer = IntArray(V + 1) { Int.MAX_VALUE }  // 최단 거리
    answer[K] = 0
    repeat(E) {
        val u = i()
        val v = i()
        val w = i()
        graph[u][v] = min(graph[u][v] ?: Int.MAX_VALUE, w)  // 중복으로 들어올 때 더 작은 값만 저장
    }
    val queue = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.second - o2.second }
    queue.add(K to 0)

    while (queue.isNotEmpty()) {
        val (mid, dist) = queue.poll()
        for (arrive in graph[mid].keys) {
            val nValue = dist + graph[mid][arrive]!!
            if (nValue < answer[arrive]) {
                queue += arrive to nValue
                answer[arrive] = nValue
            }
        }
    }

    val sb = StringBuilder()
    for (i in 1..V) {
        if (answer[i] == Int.MAX_VALUE) sb.append("INF\n")
        else sb.appendLine(answer[i])
    }
    print(sb)
}

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

0
2
3
7
INF


5 9
1
5 1 1
1 2 5
1 3 5
2 3 3
2 4 1
3 4 6
3 2 7
1 2 2
4 3 1

0
2
4
3
INF


4 5
1
1 3 2
3 2 4
1 4 2
4 2 1
1 3 5

0
3
2
2


6 6
1
1 2 1
2 5 1
5 6 1
1 3 10
3 4 5
6 3 1

0
1
4
9
2
3

*/