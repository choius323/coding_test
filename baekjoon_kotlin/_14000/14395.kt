package baekjoon_kotlin._14000

/*

14395번 - 4연산
https://www.acmicpc.net/problem/14395
분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색

s부터 BFS를 탐색하며 아스키 코드 순서로 연산을 실행한다.

*/

fun main() {
    data class Elem(val num: Long, val oper: String)
    data class Oper(val char: Char, val func: (Long) -> Long)

    val (s, t) = readln().split(" ").map { it.toLong() }
    if (s == t) return print(0)

    val visited = mutableSetOf<Long>()
    val opers = listOf(Oper('*') { it * it }, Oper('+') { it + it }, Oper('-') { it - it }, Oper('/') { it / it })
    val queue = ArrayDeque<Elem>()
    queue += Elem(s, "")

    while (queue.isNotEmpty()) {
        val elem = queue.removeFirst()
        if (elem.num == t) return print(elem.oper)
        elem.oper.plus(elem.num)
        for (oper in opers) {
            if (elem.num == 0L) continue
            val nextNum = oper.func(elem.num)
            if (nextNum in visited) continue
            queue += Elem(nextNum, elem.oper + oper.char)
            visited += nextNum
        }
    }
    print(-1)
}

/*

*/