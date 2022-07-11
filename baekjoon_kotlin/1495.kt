/*

1495번 - 기타리스트
https://www.acmicpc.net/problem/1495

DP를 활용해서 bottom-up 방식으로 i번째 곡의 최대값을 찾는다.
dp는 0~m까지 볼륨의 크기만큼 배열을 선언하고 각각 그 볼륨이 될 수 있는지 여부를 값으로 갖는다.
마지막엔 dp의 m->0 순서로 이동하며 가장 먼저 true인 인덱스를 출력한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val s = i()
    val m = i()
    var dp = BooleanArray(m + 1)
    dp[s] = true

    repeat(n) {
        val v = i()
        val next = BooleanArray(m + 1)
        for (volume in 0..m) {
            if (dp[volume]) {
                if (volume + v <= m) next[volume + v] = true
                if (volume - v >= 0) next[volume - v] = true
            }
        }
        dp = next
    }

    for (i in m downTo 0) if (dp[i]) return print(i)
    print(-1)
}

/*
14 40 243
74 39 127 95 63 140 99 96 154 18 137 162 14 88
*/