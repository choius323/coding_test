package baekjoon_kotlin._16000

/*

16397번 - 탈출
https://www.acmicpc.net/problem/16397
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색

각 숫자에서 A, B 버튼을 눌렀을 때 나오는 숫자를 저장한 뒤 같은 과정을 반복한다.
이 과정을 몇번 반복 해야하는지 확인하고

*/

fun main() {
    fun toB(n:Int): Int {
        if (n * 2 > 99999) return n
        val length = n.toString().length - 1
        val mostSignificantDigit = (n ushr (length * 3)) and 0x7

        // 가장 큰 자리의 숫자를 1 줄이기
        return n - (mostSignificantDigit shl (length * 3))
    }
    val (n, t, g) = readln().split(" ").map(String::toInt)
    var count = 0
    val set = mutableSetOf(n)
    var numList = listOf(n)
    while (g !in set && count < t) {
        numList = numList
            .flatMap { num ->
                setOf(num + 1, toB(num))
            }.filter { it !in set && it <= 99999 }
        set += numList
        count++
        println("$count $numList")
    }
    print(if (g in set) count else "ANG")
}