package baekjoon_kotlin._1000

/*

1715번 - 카드 정렬하기
https://www.acmicpc.net/problem/1715
분류 : 자료 구조, 그리디 알고리즘, 우선순위 큐

비교 횟수를 최소화하려면 묶음의 크기가 가장 작은 것끼리 먼저 비교하면서 모든 묶음을 비교하면 된다.
우선순위 큐를 사용하여 모든 묶음의 크기를 넣고, 가장 작은 묶음 2개를 비교 후 다시 넣는 작업을 반복했다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val pq = java.util.PriorityQueue<Int>(List(n) { r() })
    var answer = 0L
    while (pq.size > 1) {
        pq += (pq.poll()!! + pq.poll()!!).also { answer += it }
    }
    print(answer)
}

/*
4
1
2
3
10

25

1 + 10 + 11 + 2 + 13 + 3 = 40
1 + 2 + 3 + 3 + 6 + 10 = 25
1 + 3 + 4 + 2 + 6


*/