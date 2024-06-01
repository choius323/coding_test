package baekjoon_kotlin._16000

/*

16719번 - ZOAC
https://www.acmicpc.net/problem/16719
분류 : 구현, 문자열, 재귀

문자를 추가했을 때 사전 순으로 가장 앞에 오도록 해야 한다.
문자를 추가하면 그 앞의 문자을 추가하는 것 보다 그 다음 문자를 추가하는 것이 더 빠르다.
따라서 추가한 문자 이후의 문자 중 가장 작은 문자를 추가하는 재귀 함수를 수행하면 된다.

*/

fun main() {
    val str = readln()
    val checked = BooleanArray(str.length)
    var count = 0
    val answer = StringBuilder()

    fun addAnswer() {
        if (count == 0) return
        for (i in str.indices) {
            if (checked[i]) {
                answer.append(str[i])
            }
        }
        answer.appendLine()
    }

    fun recur(idx: Int) {
        if (count == str.length || idx !in str.indices) return
        while (true) {
            var minIdx = -1
            for (nextIdx in idx..str.lastIndex) {
                if ((minIdx == -1 || str[nextIdx] < str[minIdx]) && checked[nextIdx].not()) {
                    minIdx = nextIdx
                }
            }
            if (minIdx == -1) break
            checked[minIdx] = true
            count++
            addAnswer()
            recur(minIdx + 1)
        }
    }

    recur(0)

    print(answer)
}