package baekjoon_kotlin._2000

/*

2473번 - 세 용액
https://www.acmicpc.net/problem/2473
분류 : 정렬, 이분 탐색, 두 포인터

용액을 1~n 중 하나로 정하고(i) i+1을 left, n을 right로 정해서 투 포인터로 합을 0에 가깝게 조정한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val volumes = IntArray(n) { r() }.sortedArray()

    var minAbsSum = Long.MAX_VALUE
    var result = listOf(0)

    for (i in 0 until n) {
        var left = i + 1
        var right = n - 1

        while (left < right) {
            val currentSum = volumes[i].toLong() + volumes[left] + volumes[right]
            val abs = kotlin.math.abs(currentSum)
            if (abs < minAbsSum) {
                minAbsSum = abs
                result = listOf(i, left, right).map(volumes::get)
                if (minAbsSum == 0L) break
            }

            if (currentSum < 0) {
                left++
            } else {
                right--
            }
        }

        if (minAbsSum == 0L) break
    }

    print(result.joinToString(" "))
}

/*

*/