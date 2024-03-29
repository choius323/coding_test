package baekjoon_kotlin._17000

/*

17615번 - 볼 모으기
https://www.acmicpc.net/problem/17615
분류 : 그리디 알고리즘

하나의 볼을 양쪽 방향 중 하나로 이동하는 횟수를 찾는다.
한 쪽 방향에서 처음에 연속으로 나오는 볼을 제외하고, 다른 볼의 개수가 더 적은 쪽이 그 방향의 최소 이동 횟수이다.

*/

fun main() {
    fun String.minCount(): Int = minOf(count { it == 'R' }, count { it == 'B' })
    readln()
    val balls = readln()
    print(
        minOf(
            balls.dropWhile { balls.first() == it }.minCount(),
            balls.dropLastWhile { balls.last() == it }.minCount()
        )
    )
}

/*

*/