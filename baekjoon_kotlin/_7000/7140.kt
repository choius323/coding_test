package baekjoon_kotlin._7000

/*

7140번 - 데이터 만들기 1
https://www.acmicpc.net/problem/7140
분류 : 그래프 이론, 애드 혹, 해 구성하기, 데이크스트라, 최단 경로, 플로이드–워셜

다익스트라는 간선이 없으면 탐색을 종료하지만, 플로이드-워셜은 간선의 개수와 상관 없이 항상 n^3번 가중치를 계산한다.
따라서 정점이 많고 간선이 없는 그래프를 입력으로 주면 된다.

*/

fun main() {
    val n = (102..103).random()
    val sb = StringBuilder()
    sb.appendLine(n)
    repeat(n) {
        sb.appendLine(0)
    }
    sb.appendLine(1)
    sb.appendLine("${(1..50).random()} ${(51 until n).random()}")
    print(sb)
}

/*

*/