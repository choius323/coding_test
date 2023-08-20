package baekjoon_kotlin._2000

/*

2310번 - 어드벤처 게임
https://www.acmicpc.net/problem/2310
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

각 방을 탐색하며 이동할 수 있는 모든 방을 탐색하고 마지막 방에 한 번이라도 도착하면 Yes를 출력했다.
dp로 방에 도착했을 때 최대 금액을 저장하고 dp보다 작은 상태로 도착하게 되면 더 이상 진행하지 않고 넘어갔다.

DP나 우선순위 없이 BFS나 DFS를 사용하면 틀릴 거라고 생각했는데 맞는다.
데이터가 부족하거나 문제가 잘못된건가?

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Room(val type: Char, val cost: Int, val nextIndices: MutableList<Int> = mutableListOf())
    data class User(val index: Int, val money: Int)

    val s = { nextToken(); sval }
    val r = { nextToken();nval.toInt() }
    while (true) {
        val n = r()
        if (n == 0) return
        val rooms = Array(n + 1) {
            if (it == 0) {
                Room('E', 0, mutableListOf(1))
            } else {
                Room(s()[0], r(), mutableListOf<Int>().apply {
                    while (true) {
                        val index = r()
                        if (index == 0) break
                        add(index)
                    }
                })
            }
        }
        val dp = IntArray(n + 1) { -1 }
        val pq = java.util.PriorityQueue<User> { o1, o2 -> o2.money.compareTo(o1.money) }
        pq.add(User(0, 0))
        while (pq.isNotEmpty()) {
            val user = pq.poll()
            if (dp[n] != -1) break
            val nowRoom = rooms[user.index]
            for (nextIndex in nowRoom.nextIndices) {
                val nextRoom = rooms[nextIndex]
                val nextMoney = when (nextRoom.type) {
                    'E', 'L' -> maxOf(user.money, nextRoom.cost)
                    else -> user.money - nextRoom.cost
                }
                if (dp[nextIndex] >= nextMoney) continue
                dp[nextIndex] = nextMoney
                pq += User(nextIndex, nextMoney)
            }
        }
        println(if (dp[n] != -1) "Yes" else "No")
    }
}


/*
3
E 0 2 0
L 10 3 0
T 15 1 2 0
0
*/