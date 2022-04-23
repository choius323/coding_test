/*

1916번 - 최소비용 구하기
https://www.acmicpc.net/problem/1916

다익스트라 알고리즘을 활용하는 문제이다.
도시의 수가 최대 1000이기 때문에 인접 리스트를 사용해야 한다.
또, 우선순위 큐와 출발점에서 다른 점으로 가는 비용의 배열 만들어서 계산하면 O(nlogn)으로 해결할 수 있다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i() // 도시 수
    val m = i() // 버스 수
    val buses = Array(n + 1) { HashMap<Int, Int>() } // 출발 도시, 도착도시, 비용
    repeat(m) {
        val start = i()
        val goal = i()
        // 값이 중복으로 들어올 때 더 적은 값을 저장
        buses[start] += goal to buses[start].getOrDefault(goal, 100001).coerceAtMost(i())
    }
    val start = i()
    val startToGoal = IntArray(n + 1) { 100000001 }
    startToGoal[start] = 0
    val queue = java.util.PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.second - o2.second }

    queue.add(start to 0)
    while (queue.isNotEmpty()) {
        val (a, b) = queue.poll()
        for ((key, value) in buses[a]) {
            if (b + value < startToGoal[key]) {
                queue.add(key to b + value)
                startToGoal[key] = b + value
            }
        }
    }
    print(startToGoal[i()])
}

/*
4
3
1 2 1
2 3 1
3 4 1
2 4
*/