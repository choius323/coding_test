package baekjoon_kotlin._2000/*

2847번 - 게임을 만든 동준이
https://www.acmicpc.net/problem/2847

탑다운 방식으로 점수를 확인하며 최대 점수인 max를 갱신한다.
낮은 레벨의 점수가 더 높으면 max를 <다음 레벨의 점수>-1로 바꾸고 갱신된 점수와 원래 점수만큼 감소시키는 점수가 늘어난다.
낮은 레벨의 점수가 더 낮을 때는 최대 점수만 갱신하고 넘어간다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    var answer = 0
    val n = r()
    val score = List(n) { r() }
    var max = score[n - 1]
    for (i in n - 2 downTo 0) {
        if (score[i] >= max) {
            answer += score[i] - max + 1
            max -= 1
        } else max = score[i]
    }
    print(answer)
}

/*

*/