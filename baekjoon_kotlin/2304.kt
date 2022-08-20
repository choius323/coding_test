/*

2304번 - 창고 다각형
https://www.acmicpc.net/problem/2304

기둥을 높이 순으로 정렬하고 이미 나온 기둥 사이에 있지 않은 기둥만 면적을 체크한다.

*/

private data class Bar(val x: Int, val y: Int)

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val bars = List(n) { Bar(r(), r()) }.sortedBy { -it.y }
    var left = bars[0].x
    var right = bars[0].x
    var answer = bars[0].y
    for (i in 1 until n) {
        val (x, y) = bars[i]
        if (x < left) {
            answer += (left - x) * y
            left = x
        } else if (x > right) {
            answer += (x - right) * y
            right = x
        }
    }
    print(answer)
}

/*

*/