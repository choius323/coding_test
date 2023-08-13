package baekjoon_kotlin._1000/*

1082번 - 방 번호
https://www.acmicpc.net/problem/1082
분류 : 다이나믹 프로그래밍, 그리디 알고리즘

배낭 문제와 비슷하게 DP를 사용해서 풀었고, 문자열 비교 함수를 만들어서 문자열의 길이와 사전으로 비교했다.
DP 갱신은 가능한 금액 안에서 더 큰 방번호를 만들 수 있을 때 갱신했다.
같은 숫자를 여러 번 구매 할 수 있기 때문에 money를 0~m 순으로 탐색했다.
방 번호는 최대 9가 50번 올 수 있기 때문에 문자열을 사용해 저장했다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun compare(str1: String, str2: String) =
        if (str1.length != str2.length) str1.length.compareTo(str2.length) else str1.compareTo(str2)

    val r = { nextToken();nval.toInt() }
    val n = r()
    val prices = IntArray(n) { r() }
    val m = r()

    val dp = Array(m + 1) { "" }
    var max = ""
    for (money in 0..m) {
        for (i in prices.indices) {
            val nMoney = money + prices[i]
            val nStr = if (dp[money] == "0") "$i" else "${dp[money]}$i"
            if (nMoney <= m && compare(dp[nMoney], nStr) < 0) {
                dp[nMoney] = nStr
            }
        }
        if (compare(max, dp[money]) < 0) max = dp[money]
    }
    print(max)
}

//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    val r = { nextToken();nval.toInt() }
//    val n = r()
//    val prices = IntArray(n) { r() }
//    val m = r()
//    val dp = mutableMapOf<String, Int>()
//    fun recur(useMoney: Int, room: String) {
//        if ((dp[room] ?: 100) <= useMoney || (room.length > 1 && room[0] == '0')) return
//        dp += room to useMoney
//        for (i in 0 until n) {
//            val nUseMoney = useMoney + prices[i]
//            if (nUseMoney > m) continue
//            recur(nUseMoney, "$room$i")
//        }
//    }
//    recur(0, "")
//    print(dp.keys.maxOfWith({ o1, o2 ->
//        if (o1.length != o2.length) o1.length.compareTo(o2.length)
//        else o1.compareTo(o2)
//    }) { it })
//}

/*

*/