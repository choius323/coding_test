/*

10830번 - 행렬 제곱
https://www.acmicpc.net/problem/10830

재귀함수를 사용해서 제곱을 구하면 된다.
방법은 1629번(https://www.acmicpc.net/problem/1629)과 같지만 행렬이 돼서 값을 넘겨주지 않고 입력받은 행렬을 바꾸는 방식을 사용했다.

*/

package baekjoon_kotlin._10000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    i()
    val b = nval.toLong()
    var arr = Array(n) { IntArray(n) { i() % 1000 } }
    val arrOrigin = arr.clone()
    val sb = StringBuilder()

    fun time(isPow: Boolean = true) {
        val temp = Array(n) { IntArray(n) }
        for (y in 0 until n) for (x in 0 until n) {
            repeat(n) {
                temp[y][x] += arr[y][it] * if (isPow) arr[it][x] else arrOrigin[it][x]
            }
            temp[y][x] %= 1000
        }
        arr = temp
    }

    fun pow(b: Long) {
        if (b == 1L) return
        pow(b / 2)
        time()
        if (b % 2 == 1L) time(false)
    }

    pow(b)
    arr.forEach { it.forEach { it2 -> sb.append("$it2 ") };sb.appendLine() }
    print(sb)
}

/*
2 100000000000
1 1
1 1

2 3
1000 1000
999 999

2 3
2 3
0 1

*/