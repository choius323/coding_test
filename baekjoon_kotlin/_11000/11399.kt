/*

11399번 - ATM
https://www.acmicpc.net/problem/11399

기다리는 시간이 가장 적어지는 방법은 조금 걸리는 사람부터 차례대로 하는 것이다.
그러면 처음 한 사람은 전체 인원 수 만큼 시간에 더해주고, 마지막 사람은 한 번만 더해주면 된다.

*/

package baekjoon_kotlin._11000

fun main() {
    readLine()
    val people = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    var answer = 0
    people.sortedDescending().forEachIndexed { i, t ->
        answer += t * (i + 1)
    }
    print(answer)
}