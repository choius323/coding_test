/*

5525번 - IOIOI
https://www.acmicpc.net/problem/5525

입력받은 글자를 처음부터 탐색하며 I일 때 IO가 나온 횟수를 구하면 된다.
이 때 IO를 찾기 위해 확인한 곳은 다시 탐색할 필요가 없다.

*/

package baekjoon_kotlin._5000

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val str = br.readLine()
    var i = 0
    var answer = 0
    while (i < str.length - 2) {
        var count = 0
        if (str[i] == 'I') {
            while (i < str.length - 2 && str[i + 1] == 'O' && str[i + 2] == 'I') {
                count += 1
                i += 2
            }
            if (count >= n)
                answer += count - n + 1
        }
        i += 1
    }
    println(answer)
}
/*
1
13
OOIOIOIOIIOII

4

2
13
OOIOIOIOIIOII

2
 */