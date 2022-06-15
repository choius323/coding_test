/*

14888번 - 연산자 끼워넣기
https://www.acmicpc.net/problem/14888

DFS로 탐색하며 연산자를 사용해서 계산하면 된다.
연산자의 남은 회수와 관계 없이 각 연산자는 함수 호출 한 번에 하나씩 사용해야 한다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val num = IntArray(n) { i() }
    val oper = IntArray(4) { i() }
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    fun dfs(number: Int, index: Int) {
        if (index == n) {
            max = maxOf(number, max)
            min = minOf(number, min)
            return
        }
        repeat(4) {
            if (oper[it] > 0) {
                oper[it] -= 1
                dfs(
                    when (it) {
                        0 -> number + num[index]
                        1 -> number - num[index]
                        2 -> number * num[index]
                        else -> number / num[index]
                    }, index + 1
                )
                oper[it] += 1
            }
        }
    }
    dfs(num[0], 1)
    print("$max\n$min")
}

/*

*/