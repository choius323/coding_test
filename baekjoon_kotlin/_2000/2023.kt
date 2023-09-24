package baekjoon_kotlin._2000

/*

2023번 - 신기한 소수
https://www.acmicpc.net/problem/2023
분류 : 수학, 정수론, 백트래킹, 소수 판정

사용 가능한 메모리가 작기 때문에 에라토스테네스의 체를 사용하면 메모리 초과가 발생한다.
1자리 소수는 2, 3, 5, 7만 가능하고 2자리 이상의 소수는 항상 마지막 자리가 홀수라는 것을 알아야 한다.
이후 규칙에 맞게 수를 만들고 그 수가 소수인지 i~sqrt(i)까지 직접 나누며 나누어떨어지는지 확인한다.

*/

fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()

    fun isPrime(num: Int): Boolean {
        for (i in 2..kotlin.math.sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) return false
        }
        return true
    }

    fun recur(str: String) {
        if (n == str.length) {
            if (isPrime(str.toInt())) {
                sb.appendLine(str)
            }
            return
        }
        for (c in 1..9 step 2) {
            val next = str + c
            if (isPrime(next.toInt())) {
                recur(str + c)
            }
        }
    }

    listOf(2, 3, 5, 7).forEach {
        recur("$it")
    }

    print(sb)
}

/*

*/