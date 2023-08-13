package baekjoon_kotlin._1000/*

1106번 - 호텔
https://www.acmicpc.net/problem/1106

DP를 활용하는 문제이다.
처음에 사용한 방법은 01 배낭문제 처럼 모든 홍보를 순차적으로 돌며 가격에 따라 가장 많은 인원을 기록한다.
만약 인원이 충족되면 미리 저장된 최소값과 비교해 더 적은 값을 최소값으로 갱신한다.
dp에 저장하는 값은 이전 광고의 현재 비용일 때 인원, 이전 광고에 현재 광고를 더한 인원, 현재 광고를 한번 더 한 인원 중 최대값을 저장한다.
배열의 인덱스를 가격이 아닌 인원으로 정했으면 더 효율적이었을 것 같다.

다른 사람의 코드를 찾다가 발견한 방법은 배열의 인덱스를 인원, 값을 가격으로 하는 방법이다.
내 방법과 큰 차이점은 DP를 채우는 방식이 각 인덱스마다 모든 홍보를 다 체크하고 넘어간다는 것이다.
그렇게 하면 홍보 배열을 정렬할 필요도 없고 dp 배열을 여러개 만들 필요도 없다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Ad(val cost: Int, val num: Int)

    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val c = i()
    val n = i()
    val ads = List(n) { Ad(i(), i()) }.sortedBy { -it.cost } //역순으로 해야 DP가 0부터 데이터가 제대로 축적된다.
    var ans = 100000
    var dp = IntArray(ans + 1) // 인덱스 : 가격, 값 : 인원
    for ((cost, num) in ads) {
        val next = IntArray(ans + 1)
        for (nCost in cost..ans) {
            next[nCost] = maxOf(dp[nCost], dp[nCost - cost] + num, next[nCost - cost] + num)
            if (next[nCost] >= c && ans > nCost) {
                ans = nCost
                break
            }
        }
        dp = next
    }
//    for (i in 0 until dp.size/5) {
//        print(("${i*5} : ").padStart(5, ' '))
//        for (j in 0..4)
//            print("${(dp[i * 5 + j]).toString().padStart(3, ' ')} ")
//        println()
//    }
    print(ans)
}


// 출처 : https://www.acmicpc.net/source/40253462
//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    fun i(): Int {
//        nextToken(); return nval.toInt()
//    }
//
//    val c = i()
//    val n = i()
//    var max = 0
//    val ads = Array(n) {
//        val cost = i()
//        val people = i()
//        if (max < people) max = people
//        cost to people
//    } // 비용 to 인원
//    val dp = IntArray(c + max + 1) { 100000 }
//    dp[0] = 0
//
//    for (i in 1..c + max) // 인원 배열
//        for (j in 0 until n) // 홍보
//            if (i >= ads[j].second) // 홍보를 할 수 있는지 확인
//                dp[i] = minOf(dp[i], dp[i - ads[j].second] + ads[j].first)
//    var ans = dp[c]
//    for (i in c + 1..c + max)
//        if (ans > dp[i]) ans = dp[i]
//    print(ans)
//}

/*
100 1
1000 1

100 3
7 12
30 60
20 30
*/