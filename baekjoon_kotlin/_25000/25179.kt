/*

25179번 - 배스킨라빈스~N~귀엽고~깜찍하게~
https://www.acmicpc.net/problem/25179

언제나 최상의 플레이만 하므로 공식을 구하면 된다.
단 숫자가 매우 크다는 점을 조심해야 한다.

*/

package baekjoon_kotlin._25000

fun main() = print(if (readLine()!!.split(" ").map { it.toULong() }.let { (it[0] - 1u) % (it[1] + 1u) != 0uL }) "Can win" else "Can't win")

/*
1000000000000000000
999999999999999999
*/