package baekjoon_kotlin._20000/*

20113번 - 긴급 회의
https://www.acmicpc.net/problem/20113

0을 제외한 값을 투표 횟수에 기록하면서 최대값인 인덱스와 같은 값이 나왔는지 저장할 변수를 갱신하며 모든 값을 읽으면 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    nextToken()
    val n = nval.toInt()
    val vote = IntArray(101)
    var same = true
    var idx = 0
    repeat(n) {
        nextToken()
        val v = nval.toInt()
        if (v != 0) {
            vote[v]++
            if (idx == v || vote[idx] < vote[v]) {
                idx = v
                same = false
            } else if (vote[idx] == vote[v]) {
                same = true
            }
        }
    }
    print(if (same) "skipped" else idx)
}

/*

*/