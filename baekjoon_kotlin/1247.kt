/*

1247번 - 부호
https://www.acmicpc.net/problem/1247

각 숫자를 BigInteger로 바꿔서 계산한다.

*/

import java.math.BigInteger

fun main() = System.`in`.bufferedReader().run {
    repeat(3) {
        var sum = BigInteger.ZERO
        repeat(readLine().toInt()) { sum += readLine().toBigInteger() }
        println(if (sum < BigInteger.ZERO) '-' else if (sum > BigInteger.ZERO) '+' else '0')
    }
}

/*

*/