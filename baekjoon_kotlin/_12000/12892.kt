package baekjoon_kotlin._12000

/*

12892번 - 생일 선물
https://www.acmicpc.net/problem/12892
분류 : 정렬, 두 포인터

투 포인터로 right를 1칸씩 옮기며 그 때 얻을 수 있는 최대 가치를 구했다.
구하기 전에는 가격을 기준으로 오름차순 정렬을 해야 투 포인터를 사용해서 가격의 차이로 최대 가치를 구할 수 있다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Gift(val p: Int, val v: Int)
    val r = {nextToken();nval.toInt()}
    val n = r()
    val d = r()
    val gifts = Array(n) { Gift(r(), r()) }.sortedArrayWith(compareBy(Gift::p))
    var left = 0
    var value = 0L
    var maxValue = 0L
    for(right in 0 until n) {
        while(left < right && gifts[right].p - gifts[left].p >= d) {
            value -= gifts[left].v
            left++
        }
        value += gifts[right].v
        maxValue = maxOf(maxValue, value)
    }
    print(maxValue)
}

/*

*/