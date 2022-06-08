/*

12779번 - 상품 is 뭔들
https://www.acmicpc.net/problem/12779

부동소수점으로 루트의 정확도가 떨어지기 때문에 루트를 다시 계산해준다.
기약분수는 분자와 분모를 최대 공양ㄱ수로 나눠주면 되는데 최대공약수는 유클리드 호제법을 재귀함수로 구현했다.

*/

package baekjoon_kotlin

import kotlin.math.floor
import kotlin.math.pow

fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }

    var s = floor(a.toDouble().pow(0.5))
    var e = floor(b.toDouble().pow(0.5))
    while (s.pow(2).toLong() <= a)
        s += 1
    while (e.pow(2).toLong() <= b)
        e += 1
    val x = (e - s).toLong()
    val y = b - a

    fun gcd(i: Long, j: Long): Long = if (j != 0L) gcd(j, i % j) else i
    val g = gcd(x, y)
    print(if (x == 0L) 0 else "${x/g}/${y/g}")
}

/*
1152921504606846975 1152921504606846976
*/