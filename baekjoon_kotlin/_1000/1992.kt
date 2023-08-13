/*

1992번 - 쿼드트리
https://www.acmicpc.net/problem/1992

평범한 dfs 문제이지만 문제를 이해하는데 조금 힘들었다.
4개로 나누지 않으면 괄호 없이 출력해야 한다.

*/

package baekjoon_kotlin._1000

import java.io.BufferedReader
import java.io.InputStreamReader

private val sb = StringBuilder()
lateinit var picture: Array<CharArray>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    picture = Array(br.readLine().toInt()) { br.readLine().toCharArray() }

    dfs(0, 0, picture.size)
    println(sb)
}

private fun dfs(l: Int, t: Int, len: Int) {
    var isSame = true
    forLoop@ for (y in t until t + len) {
        for (x in l until l + len) {
            if (picture[y][x] != picture[t][l]) {
                isSame = false
                break@forLoop
            }
        }
    }

    if (isSame) {
        sb.append(picture[t][l])
    } else {
        sb.append("(")
        for (y in intArrayOf(t, t+len/2)){
            for (x in intArrayOf(l, l+len/2)){
                dfs(x, y, len/2)
            }
        }
        sb.append(")")
    }
}

/*
8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011

((110(0101))(0010)1(0001))



4
1010
0000
1010
0000
 */