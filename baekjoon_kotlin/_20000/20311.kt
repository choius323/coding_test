package baekjoon_kotlin._20000

/*

20311번 - 화학 실험
https://www.acmicpc.net/problem/20311
분류 : 자료 구조, 그리디 알고리즘, 정렬, 해 구성하기, 우선순위 큐

가장 개수가 많고 직전에 사용하지 않은 색깔을 우선해서 사용한다.
이전에 사용했던 색깔이 가장 많다면 그 다음으로 많은 색깔을 사용한다.
조건에 맞게 색깔을 사용할 수 없다면 -1을 출력한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Color(val count: Int, val type: Int)

    val r = { nextToken();nval.toInt() }
    val n = r()
    val k = r()
    val pq = java.util.PriorityQueue(compareByDescending(Color::count))
    repeat(k) {
        pq.add(Color(r(), it + 1))
    }
    val sb = StringBuilder()
    var lastType = -1
    while (pq.isNotEmpty()) {
        var color: Color? = null
        if (pq.peek().type == lastType) {
            val keep = pq.remove()
            if (pq.isNotEmpty()) {
                color = pq.poll()
            }
            pq.add(keep)
        } else {
            color = pq.poll()
        }
        if (color == null) {
            return print(-1)
        } else {
            sb.append(color.type).append(' ')
            if (color.count > 1) {
                pq.add(Color(color.count - 1, color.type))
            }
            lastType = color.type
        }
    }
    print(sb)
}

/*

*/