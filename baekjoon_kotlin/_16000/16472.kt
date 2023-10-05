package baekjoon_kotlin._16000

/*

16472번 - 고냥이
https://www.acmicpc.net/problem/16472
분류 : 두 포인터

투 포인터로 right point를 이동시키며 그 때 최대 문자열 길이 n을 구한다.
각 문자마다 나온 횟수를 저장하는 배열을 만들고 값이 0으로 감소하거나 1로 증가할 때 새로운 문자 종류라고 판단한다.

*/

fun main() {
    val n = readln().toInt()
    val str = readln()
    var left = 0
    var answer = 0
    val wordsCount = IntArray('z' - 'a' + 1)
    var countKind = 0
    for (right in str.indices) {
        val index = str[right] - 'a'
        if (++wordsCount[index] == 1) {
            countKind++
        }
        while (countKind > n) {
            val leftIndex = str[left] - 'a'
            left++
            wordsCount[leftIndex]--
            if (wordsCount[leftIndex] == 0) {
                countKind--
            }
        }
        answer = maxOf(answer, right - left + 1)
    }
    print(answer)
}

/*

*/