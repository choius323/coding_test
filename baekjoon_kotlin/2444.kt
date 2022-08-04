/*

2444번 - 별 찍기 - 7
https://www.acmicpc.net/problem/2444

i번째 줄의 공백은 항상 |n-1|개이며 별은 n번째 줄까지 i*2-1개, n번째 줄부터 (n*2-1)*2-1개이다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val sb = StringBuilder()
    for (i in 1 until n * 2)
        sb.append(" ".repeat(kotlin.math.abs(n - i)))
            .appendLine("*".repeat((if (i <= n) i else n * 2 - i) * 2 - 1))
    print(sb)
}

/*

*/