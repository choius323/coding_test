package baekjoon_kotlin._2000

/*

2343번 - 기타 레슨
https://www.acmicpc.net/problem/2343
분류 : 이분 탐색, 매개 변수 탐색

한 블루레이의 녹화 길이를 기준으로 하는 매개 변수 탐색을 수행한다.
최소는 -1, 최대는 모든 영상을 한 블루레이에 담는 시간을 기준으로 하고, 중앙값으로 하는 블루레이를 만들 수 있는지 확인한다.
최소 개수를 찾아야 하기 때문에 만들 수 있다면 최대 개수를 줄인다.(lower bound)

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val times = IntArray(n) { r() }

    fun canSell(maxTime: Int): Boolean {
        var count = 1
        var sumTime = 0
        for (time in times) {
            sumTime += time
            if (sumTime > maxTime) {
                count++
                sumTime = time
            }
            if (count > m || time > maxTime) return false
        }
        return true
    }

    var left = -1
    var right = times.sum() + 1
    while (left + 1 < right) {
        val mid = (left + right) / 2
        if (canSell(mid)) {
            right = mid
        } else {
            left = mid
        }
    }
    print("$left $right")
}