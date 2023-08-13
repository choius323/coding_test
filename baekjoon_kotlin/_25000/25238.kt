/*

25238번 - 가희와 방어율 무시
https://www.acmicpc.net/problem/25238

a - (a * b / 100) >= 100
-> a * (100 - b) / 100 >= 100
-> a * (100 - b) >= 10000
답은 이 식이 True면 0이고, False면 1이다.

왼쪽 식이 9999와 10000 사이가 나오는 데이터는 없는 것 같다.

*/

package baekjoon_kotlin._25000

fun main() = readLine()!!.split(" ").map { it.toInt() }.let { print(if (it[0] * (100 - it[1]) > 9999) 0 else 1) }

/*

*/