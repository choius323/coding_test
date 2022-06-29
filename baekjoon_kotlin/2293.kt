/*

2293번 - 동전 1
https://www.acmicpc.net/problem/2293

DP를 활용하는 문제이다.
m원의 동전은 m원을 만들 때 1가지 경우를 갖고, m+1원일 때 1원의 경우의 수 만큼 갖고, m+i원일 때 i원의 경우의 수 만큼 갖는다.
이렇게 각 동전에 대해 m~k원일 때 경우의 수를 저장하면 된다.
단, 1~k원 각각의 경우를 각 동전에 대해 먼저 계산하면 중복이 나올 수 있으므로, 각 동전의 1~k원까지 경우의 수를 먼저 계산해야 한다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val k = i()
    val money = IntArray(k + 1)
    money[0] = 1

    repeat(n) {
        val m = i()
        for (i in m..k)
            money[i] += money[i - m]
    }
    print(money[k])
}

/*

*/