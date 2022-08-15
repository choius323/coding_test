/*

25425번 - 운동회
https://www.acmicpc.net/problem/25425

등수의 최댓값은 시작할 때 팀의 수와 자신의 팀을 제외한 각 팀이 모두 1명씩 있을 때 팀의 수 중 작은 값이다.
최솟값은 나머지 팀들이 최대 인원 수 만큼 있을 때이다.

*/

fun main() = System.`in`.bufferedReader().run {
    val (n, m, a, k) = readLine().split(" ").map { it.toLong() }
    val other = a - k
    val rank = other / m + if (other % m == 0L) 1 else 2
    print("${minOf(other + 1, n)} $rank")
}

/*
30 5 51 3
*/