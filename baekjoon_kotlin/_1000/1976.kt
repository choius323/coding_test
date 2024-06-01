package baekjoon_kotlin._1000

/*

1976번 - 여행 가자
https://www.acmicpc.net/problem/1976
분류 : 자료 구조, 그래프 이론, 그래프 탐색, 분리 집합

플로이드-워셜을 사용해 각 도시끼리 연결되어 있는지 확인한다.
이후 여행 계획에 있는 도시가 연결되어 있는지 확인 후 답을 출력한다.
여행 계획에 시작 도시가 또 있을 수 있기 때문에 같은 도시로 이동할 수 있다는 것을 표시해 두어야 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val roads = Array(n) { a -> BooleanArray(n) { b -> r() == 1 || a == b } }
    for (b in 0 until n) for (a in 0 until n) for (c in 0 until n) {
        if (roads[a][b] && roads[b][c]) {
            roads[a][c] = true
        }
    }
    val start = r() - 1
    print(if (List(m - 1) { r() }.all { roads[start][it - 1] }) "YES" else "NO")
}

/*
3
1
0 1 0
1 0 1
0 1 0
1

YES


1
1
0
1



5
4
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
5 2 3 4 1

NO

*/