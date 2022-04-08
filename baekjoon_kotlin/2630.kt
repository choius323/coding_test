/*

2630번 - 색종이 만들기
https://www.acmicpc.net/problem/2630

기본적인 dfs문제이다.
dfs 함수를 main 내부에 선언하면 전역변수를 따로 만들어주지 않아도 된다.


*/

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var paper: Array<IntArray>
private var white = 0
private var blue = 0


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    paper = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    dfs(0, 0, n)

    print("$white\n$blue")
}

private fun dfs(left: Int, top: Int, length: Int) {
    for (t in top until top + length) {
        for (l in left until left + length) {
            if (paper[top][left] != paper[t][l]) {
                dfs(left, top, length / 2)
                dfs(left + length / 2, top, length / 2)
                dfs(left, top + length / 2, length / 2)
                dfs(left + length / 2, top + length / 2, length / 2)
                return
            }
        }
    }
    if (paper[top][left] == 1)
        blue += 1
    else
        white += 1
}