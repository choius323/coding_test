/*

11000번 - 강의실 배정
https://www.acmicpc.net/problem/11000

강의를 s, t로 정렬한 뒤 그리디 알고리즘을 사용해 우선순위 큐에 넣으면 된다.
우선순위 큐에는 강의가 끝나는 시간만 저장하면 된다.

강의는 우선 s를 기준으로 정렬하기 때문에 큐의 첫번째만 비교해도 조건을 만족한다.

*/

package baekjoon_kotlin._11000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Lecture(val s: Int, val t: Int)

    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val lecture = Array(i()) { Lecture(i(), i()) }
    lecture.sortWith(compareBy({ it.s }, { it.t }))
    val room = java.util.PriorityQueue<Int>()
    for ((s, t) in lecture) {
        if ((room.peek() ?: -1) <= s) room.poll()
        room.add(t)
    }
    print(room.size)
}

/*
11
1 3
2 4
4 4
5 5
2 4
1 5
1 2
3 5
0 0
2 8
1 100000000

6

0 0, 1 3, 3 5, 5 5
1 2, 2 4, 4 4
2 4
2 8
1 100000000
1 5
*/