package baekjoon_kotlin._14000

/*

14863번 - 서울에서 경산까지
https://www.acmicpc.net/problem/14863
분류 : 다이나믹 프로그래밍

이전 도시로 돌아올 수 없기 때문에 dp를 사용해 각 도시에 이동할 때 걸린 시간과 최대 비용을 저장한다.
시간을 map으로 사용했지만, 배열을 사용하는 게 더 빠르다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Trans(val time: Int, val cost: Int)

    val r = { nextToken();nval.toInt() }
    val n = r()
    val k = r()
    val routes = List(n) { listOf(Trans(r(), r()), Trans(r(), r())) }
    var dp = mapOf(0 to 0) // 시간, 비용
    for (route in routes) {
        val nextDp = mutableMapOf<Int, Int>()
        for (trans in route) {
            for (dpTrans in dp) {
                val nextTime = trans.time + dpTrans.key
                val nextCost = trans.cost + dpTrans.value
                nextDp.compute(nextTime) { _, value -> maxOf(nextCost, value ?: 0) }
//                nextDp[nextTime] = maxOf(nextCost, nextDp[nextTime] ?: 0)
            }
        }
        dp = nextDp
    }
    print(dp.maxOf { if (it.key > k) 0 else it.value })
}

/*

*/