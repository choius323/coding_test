package baekjoon_kotlin._21000/*

21278번 - 호석이 두 마리 치킨
https://www.acmicpc.net/problem/21278
분류 : 그래프 이론, 브루트포스 알고리즘, 그래프 탐색,너비 우선 탐색, 플로이드–워셜

N이 100이기 때문에 플로이드 워셜을 사용해도 최대 100^3=1000000번의 연산으로 모든 건물 사이의 거리를 구할 수 있다.
그 후 임의의 건물 2개를 선택하고, 그 건물들과 모든 건물 사이의 가장 가까운 거리의 합을 구한다.
그 합이 가장 작은 건물 2개를 고르면 된다.
건물 번호가 작은 것 부터 선택해야 하므로 건물 2개를 고를 때 작은 번호부터 찾는다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val range = 0 until n

    val roads = Array(n) { IntArray(n) { 999 } }
    repeat(n) { roads[it][it] = 0 }
    repeat(r()) {
        val a = r() - 1
        val b = r() - 1
        roads[a][b] = 1
        roads[b][a] = 1
    }
    for (j in range) for (i in range) for (k in range) {
        roads[i][k] = minOf(roads[i][k], roads[i][j] + roads[j][k])
    }

    var minSumDist = 9999
    var minA = 0
    var minB = 0
    for (a in range) for (b in a + 1 until n) {
        val sumDist = roads[a].zip(roads[b]).sumOf { minOf(it.first, it.second) }
        if (sumDist < minSumDist) {
            minA = a
            minB = b
            minSumDist = sumDist
        }
    }

    print("${minA + 1} ${minB + 1} ${minSumDist * 2}")
}

/*

*/