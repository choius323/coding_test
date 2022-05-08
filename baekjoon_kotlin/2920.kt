/*

2920번 - 음계
https://www.acmicpc.net/problem/2920

오름차순과 내림차순은 숫자가 정해져있기 때문에 str == "1 2 3 4 5 6 7 8" -> "ascending" 이런 식으로 풀어도 된다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    var a = true
    var d = true
    repeat(8) {
        nextToken()
        val n = nval.toInt()
        if (n != it + 1) a = false
        if (n != 8 - it) d = false
    }
    print(if (a) "ascending" else if (d) "descending" else "mixed")
}

/*

*/