/*

25183번 - 인생은 한 방
https://www.acmicpc.net/problem/25183

char는 +나 -가 된다는 점을 이용해서 풀었다.

*/

package baekjoon_kotlin._25000

fun main() = System.`in`.bufferedReader().run {
    val n = readLine().toInt()
    var count = 1
    val str = readLine().toCharArray()
    for (i in 1 until n) {
        if (str[i - 1] - 1 == str[i] || str[i - 1] + 1 == str[i]) count++
        else count = 1
        if (count == 5) break
    }
    print(if (count == 5) "YES" else "NO")
}

/*

*/