package baekjoon_kotlin._2000/*

2606번 - 바이러스
https://www.acmicpc.net/problem/2606

BFS를 활용했고 DFS도 가능하다.
HashMap을 통해 데이터를 추가했고, 방문했던 컴퓨터는 HashMap.keys를 활용했다.

답을 맞추고 다른 사람들의 코드를 확인했는데 대부분 나와 다른 방식을 사용했다.
우선 데이터를 입력 받을 때 HashMap이 아닌 n*n 배열을 사용했다.
데이터를 탐색할 때는 computer[a][b]에 (i in computer[a])과 같은 방식을 사용해서 큐에 추가했다.
또, 방문했던 노드는 길이가 n인 배열을 사용해서 i에 방문하기 전에는 visitied[i]가 0, 방문 후에는 1로 바꾸는 방식을 사용했다.

*/

fun main() = java.io.BufferedReader(System.`in`.bufferedReader()).run {
    readLine()
    val computer = HashMap<Int, IntArray>()
    repeat(readLine().toInt()) {
        val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
        computer[b] = computer.getOrDefault(b, intArrayOf()) + a
        computer[a] = computer.getOrDefault(a, intArrayOf()) + b
    }

    val queue = ArrayDeque<Int>()
    queue.add(0)
    val visited = hashMapOf(Pair(0, 0))

    var count = 0
    while (queue.isNotEmpty()) {
        val visit = queue.removeFirst()
        for (nextVisit in computer[visit] ?: intArrayOf()) {
            if (nextVisit !in visited) {
                queue.add(nextVisit)
                visited[nextVisit] = 0
                count += 1
            }
        }
    }
    print(count)
}

/*
4
4
1 2
2 3
3 4
4 1

3


7
6
1 2
2 3
1 5
5 2
5 6
4 7

4
 */