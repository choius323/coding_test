package baekjoon_kotlin._1000/*

1461번 - 도서관
https://www.acmicpc.net/problem/1461

마지막은 다시 돌아올 필요가 없기 때문에 걸음 수는 (m의 배수번째 책까지의 거리 * 2) - (가장 먼 책의 거리)이다.
m의 배수는 좌표가 음수, 양수인 책 각각 계산해야 하며 양쪽의 끝에 있는 책은 m개를 채우지 못하더라도 그냥 돌아와야 한다.

책의 좌표를 입력받은 후 정렬해서 먼저 음수 좌표의 책을 정리하며 양수가 나올 때 까지 탐색하고, 걸음을 계산한다.
그 후에 양수가 나오면 그 이후의 책을 정리하며 걸음을 계산한다.
마지막으로 걸음에 2를 곱하고 가장 멀리 있는 책의 거리를 뺀다.

*/

import kotlin.math.absoluteValue

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val books = IntArray(n) { r() }.apply { sort() }
    var plusIndex = n
    var walk = 0

    var count = 0
    for (i in 0 until n) {
        if (books[i] > 0) {
            plusIndex = i
            break
        } else if (count == 0) {
            walk += -books[i]
        }

        count++

        if (count == m) {
            count = 0
            continue
        }
    }

    for (i in n - 1 downTo plusIndex step m) {
        walk += books[i]
    }

    walk *= 2
    if (books.first().absoluteValue > books.last()) {
        walk += books.first()
    } else {
        walk -= books.last()
    }

    print(walk)
}

/*

*/