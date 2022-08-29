/*

1246번 - 온라인 판매
https://www.acmicpc.net/problem/1246

P가 1 3 5원일 때 1원으로 제한하면 총 3원, 2원이면 2*2=4원, 3원이면 3*2=6원 처럼 계란의 가격보다 더 높은 가격을 제시한 인원에 가격을 곱한 것이 수익이 된다.
따라서 가격*인원수를 매번 계산하며 최대 수익과 그때 가격을 계산하는 반복문을 작성한다.
반복문의 횟수는 인원과 계란의 개수 중 더 작은 값을 기준으로 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val prices = List(m) { r() }.sortedDescending()
    var sum = 0
    var price = 0
    for (i in 0 until minOf(n, m))
        if (sum < prices[i] * (i + 1)) {
            price = prices[i]
            sum = price * (i + 1)
        }
    print("$price $sum")
}

/*
7 5
1
5
5
6
7
*/