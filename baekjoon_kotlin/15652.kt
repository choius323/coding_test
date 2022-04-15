/*

15652번 - N과 M (4)
https://www.acmicpc.net/problem/15652

스택을 이용해서 DFS와 비슷한 방식으로 풀었다.
평범한 DFS처럼 위치, 문자열 등을 전달하며 풀어도 된다.

*/

package baekjoon_kotlin

fun main() = (System.`in`.bufferedReader()).run {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    val stack = ArrayList<Int>()
    fun dfs() {
        for (i in stack.getOrElse(stack.size-1){1}..n) {
            stack.add(i)
            if (stack.size == m) {
                stack.forEach { sb.append("$it ") }
                sb.append("\n")
            } else {
                dfs()
            }
            stack.removeLast()
        }
    }
    dfs()
    print(sb)
}

/*

*/