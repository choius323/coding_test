package baekjoon_kotlin._28000

/*

28423번 - 게임
https://www.acmicpc.net/problem/28423
분류 : 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 깊이 우선 탐색

L부터 R까지 f(x)를 실행하며 g(x)를 찾는다.
이미 f(x)를 했던 숫자이면 이전에 사용했던 결과를 다시 사용한다.

*/

fun main() {
    val (L, R) = readln().split(" ").map(String::toInt)
    val result = IntArray(100001) { -2 }

    fun Int.getDigitSum() = toString().fold(0) { acc, c -> acc + c.digitToInt() }
    fun Int.getDigitMulti() = toString().fold(1) { acc, c -> acc * c.digitToInt() }

    fun fx(num: Int): Int {
        if (result[num] == -3) return 0
        if (result[num] != -2) return result[num]
        val next = ("${num.getDigitSum()}${num.getDigitMulti()}").toInt()
        result[num] = -3
        result[num] = when {
            next == num -> 1
            next > 100000 -> -1
            else -> fx(next)
        }
        return result[num]
    }

    var sum = 0
    for (i in L..R) {
        if (result[i] == -2) {
            fx(i)
        }
        sum += result[i]
    }
    print(sum)
}