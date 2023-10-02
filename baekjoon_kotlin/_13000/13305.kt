package baekjoon_kotlin._13000

/*

13305번 - 주유소
https://www.acmicpc.net/problem/13305
분류 : 그리디 알고리즘

기름통의 크기가 무제한이기 때문에 i번째 도시에 도착할 때까지 최소한의 가격으로 필요한 만큼 모두 채우는 것이 좋다.
i번 도시에 도착하기 전 까지 기름의 최소 가격을 구하고 i-1에서 i번째 도시까지의 거리와 최소 가격을 곱한 것을 비용에 더한다.
이 과정을 모든 도시에 반복하면 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toLong() }
    val n = r().toInt()
    val distanceList = LongArray(n - 1) { r() }
    val priceList = LongArray(n) { r() }
    var minPrice = Long.MAX_VALUE
    var answer = 0L
    for (i in 0..n - 2) {
        minPrice = minOf(minPrice, priceList[i])
        answer += minPrice * distanceList[i]
    }
    print(answer)
}

/*

*/