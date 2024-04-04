package baekjoon_kotlin._15000

/*

15661번 - 링크와 스타트
https://www.acmicpc.net/problem/15661
분류 : 브루트포스 알고리즘, 비트마스킹, 백트래킹

양팀의 팀원이 1명 이상인 모든 경우에 몇 점의 차이가 발생하는지 계산했다.
모든 경우의 수를 계산하면 20 C 1 + 20 C 2 + .... + 20 C 18 + 20 C 19이며 약 2^20이며 100만이 조금 넘는다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val stats = Array(n) { IntArray(n) { r() } }
    var minDiff = Int.MAX_VALUE
    val selected = BooleanArray(n)

    fun sumStat(isSelected: Boolean): Int {
        var sum = 0
        for (idx1 in 0 until n) {
            if (selected[idx1] != isSelected) continue
            for (idx2 in idx1 until n) {
                if (selected[idx2] != isSelected) continue
                sum += stats[idx1][idx2] + stats[idx2][idx1]
            }
        }
        return sum
    }

    fun combi(startIdx: Int, selectCount: Int) {
        if (startIdx == n) {
            if (selectCount > 0) {
                minDiff = minOf(minDiff, kotlin.math.abs(sumStat(true) - sumStat(false)))
            }
            return
        }
        for (idx in startIdx until n) {
            selected[idx] = true
            combi(idx + 1, selectCount + 1)
            selected[idx] = false
        }
    }
    combi(0, 0)

    print(minDiff)
}

/*

*/