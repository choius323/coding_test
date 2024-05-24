package baekjoon_kotlin._15000

/*

15903번 - 카드 합체 놀이
https://www.acmicpc.net/problem/15903
분류 : 자료 구조, 그리디 알고리즘, 우선순위 큐

합을 가장 작게 하려면 작은 수끼리 더해야 한다.
따라서 우선순위 큐를 사용해 가장 작은 숫자 2개를 매번 찾은 뒤 더해서 다시 큐에 넣으면 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val pq = java.util.PriorityQueue<Long>(List(n) { r().toLong() })
    repeat(m) {
        val sum = pq.remove() + pq.remove()
        pq += sum
        pq += sum
    }
    print(pq.sum())
}

/*

*/