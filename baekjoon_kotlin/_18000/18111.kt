/*

18111번 - 마인크래프트
https://www.acmicpc.net/problem/18111

그리디를 이용해서 풀었다.
문제에 있는 작업 2가지 중 더 빠른 것을 매번 수행하면 된다.
단, 시간이 같을 때는 놓는 것을 우선으로 한다.

*/

package baekjoon_kotlin._18000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken(); return nval.toInt()
    }

    val n = i() * i()
    var b = i()
    var time = 0
    var min = 256
    var max = 0
    val blocks = IntArray(257)

    repeat(n) { blocks[i().also { min = minOf(it, min); max = maxOf(it, max) }]++ }
    while (min < max)
        if (b >= blocks[min] && blocks[min] <= blocks[max] * 2)
            blocks[min].also { time += it; b -= it; blocks[min + 1] += it; blocks[min++] = 0 }
        else blocks[max].also { time += it * 2; b += it; blocks[max - 1] += it; blocks[max--] = 0 }
//        println("$time $b $min $max ${blocks.slice(min..max)}")
    print("$time $max")
}

/*
3 4 99
0 0 0 0
0 0 0 0
0 0 0 1

3 1 1
254 255 255
*/