package baekjoon_kotlin._1000

/*

1790번 - 수 이어 쓰기 2
https://www.acmicpc.net/problem/1790
분류 : 수학, 구현

각 자리수의 숫자가 몇번 반복되는지 찾고, k번째 숫자의 원래 수와 그 수의 몇번째 수인지 찾는다.

참고 : https://trumanfromkorea.tistory.com/47

*/

private val Int.length get() = this.toString().length

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val lengths = getLengths()

    var length = k
    var index = 1 // k번째 숫자의 자리수
    while (length - lengths[index] > 0) {
        length -= lengths[index]
        index++
    }
    length -= 1
    val num = 10.pow(index - 1) + length / index // k번째 숫자
    val rem = length % index // k가 num의 몇번째 자리인지
    if (num > n) return print(-1)
    println(num.toString()[rem])
}

private fun getLengths(): IntArray {
    val lengths = IntArray(10) // 1~9, 10~99, 100~999 ...
    var num = 1
    while (num < 100_000_000) {
        val length = (num * 10 - num) * num.length
        lengths[num.length] = length
        num *= 10
    }
    lengths[9] = lengths[8] + 1
    return lengths
}

private fun Int.pow(n: Int) = Math.pow(this.toDouble(), n.toDouble()).toInt()

/*

[0, 9, 189, 2889, 38889, 488889, 5888889, 68888889, 788888889, 788888890]
[0, 9, 180, 2700, 36000, 450000, 5400000, 63000000, 720000000, 720000001]

12345678910111213141516171819202122232425
    5    10   15   20   25   30   25   30

*/