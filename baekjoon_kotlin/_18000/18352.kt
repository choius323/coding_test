package baekjoon_kotlin._18000/*

18352번 - 특정 거리의 도시 찾기
https://www.acmicpc.net/problem/18352

bfs로 그래프를 탐색하며 거리가 n일 때 탐색을 종료하고 큐에 있는 노드를 출력한다.
repeat을 실행할 때는 실행하는 순간 입력된 횟수만큼 반복하기 때문에 queue의 내용이 바뀌어도 횟수는 변하지 않는다.
출력은 오름차순으로 해야되기 때문에 마지막에 정렬을 해야 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val k = r()
    val x = r()
    val graph = List(n + 1) { ArrayList<Int>() }
    repeat(m) { graph[r()] += r() }
    val queue = ArrayDeque<Int>()
    val visited = BooleanArray(n + 1)
    visited[x] = true
    queue.add(x)
    var count = 0
    while (queue.isNotEmpty()) {
        if (count == k) break
        repeat(queue.size) {
            val node = queue.removeFirst()
            for (next in graph[node]) {
                if (!visited[next]) {
                    visited[next] = true
                    queue += next
                }
            }
        }
        count++
    }
    print(queue.sorted().joinToString("\n").ifBlank { -1 })
}

/*
4 5 3 2
1 2
1 3
2 1
2 4
2 3

*/