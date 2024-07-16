package baekjoon_kotlin._10000

/*

10330번 - 비트 문자열 재배열하기
https://www.acmicpc.net/problem/10330
분류 : 그리디 알고리즘

결국 순서대로 연속 코드를 만들어야 하기 때문에 시작부터 차례대로 개수를 채워주면 된다.
개수를 채울 때는 그 숫자보다 뒤에 있는 가장 가까운 숫자를 찾아서 뒤부터 순서대로 바꿔야 가장 적은 횟수가 된다.
코드는 1과 0만 있기 때문에 boolean으로 바꿔서 사용하면 편하다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val bools = BooleanArray(n) { r() == 1 }
    val goals = IntArray(m) { r() }

    fun swap(startBool: Boolean): Int {
        val copied = bools.copyOf()
        var count = 0
        var targetGoalIdx = -1
        var swap = 0
        for (idx in 0 until n) {
            if (targetGoalIdx == -1 || goals[targetGoalIdx] == count) {
                targetGoalIdx += 1
                count = 0
            }
            val targetNum = if (count != 0) {
                copied[idx - 1]
            } else {
                (if (idx == 0) startBool else copied[idx - 1]).not()
            }
            if (targetNum != copied[idx]) {
                var swapIdx = idx + 1
                while (swapIdx < n && targetNum != copied[swapIdx]) {
                    swapIdx++
                }
                if (swapIdx == n) return Int.MAX_VALUE
                copied[idx] = targetNum
                copied[swapIdx] = targetNum.not()
                swap += swapIdx - idx
            }
            count++
        }
        return swap
    }
    print(minOf(swap(true), swap(false)))
}

/*

*/