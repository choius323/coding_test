/*

4779번 - 칸토어 집합
https://www.acmicpc.net/problem/4779

분할 정복과 재귀를 사용해서 각 구간을 3개로 나누고 왼쪽과 오른쪽에 대해서 다시 함수를 호출한다.
1~12까지의 답을 순차적으로 구하며 저장해두면 매번 계산하지 않아서 더 빠를 수 있다.

*/

import kotlin.math.pow

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val sb = StringBuilder()
    fun dfs(answer: CharArray, left: Int, right: Int) {
        if (left == right) answer[left] = '-'
        else {
            val n = (right - left + 1) / 3
            dfs(answer, left, left + n - 1)
            dfs(answer, right - n + 1, right)
        }
    }
    while (nextToken() != -1) {
        val answer = CharArray(3.0.pow(nval.toInt()).toInt()) { ' ' }
        dfs(answer, 0, answer.lastIndex)
        sb.appendLine(answer.concatToString())
    }
    print(sb)
}

/*

*/