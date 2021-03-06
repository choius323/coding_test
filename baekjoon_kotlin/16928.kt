/*

16928번 - 뱀과 사다리 게임
https://www.acmicpc.net/problem/16928

BFS를 사용해서 풀었지만 DP를 사용하는 풀이도 가능하다.
뱀과 사다리는 다른 역할을 하는 것 같아 보이지만 같이 저장해도 된다.
StreamTokenizer를 사용하는게 split.map을 사용하는 것보다 속도가 빠르다.
?:를 잘 사용하면 식이 간단해진다.

*/

package baekjoon_kotlin

import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i():Int {nextToken();return nval.toInt()}
    val n = i()
    val m = i()
    val map = HashMap<Int, Int>()
    repeat(n + m) {
        map += i() to i()
    }
    val queue = ArrayDeque<Int>()
    val visit = BooleanArray(101)
    queue += 1
    visit[1] = true
    var answer = 0
    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val num = queue.removeFirst()
            if (num == 100) {
                print(answer)
                return@run
            }
            repeat(6) {
                var moved = num + it + 1
                if (moved <= 100) {
                    moved = map[moved] ?: moved
                    if (!visit[moved]) {
                        visit[moved] = true
                        queue.add(moved)
                    }
                }
            }
        }
        answer += 1
    }
}

/*

*/