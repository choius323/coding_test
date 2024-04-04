package baekjoon_kotlin._11000

/*

11509번 - 풍선 맞추기
https://www.acmicpc.net/problem/11509
분류 : 그리디 알고리즘

더 왼쪽에 있는 풍선을 맞춘 화살이 오른쪽 풍선을 맞추지 않는다면, 반드시 새로운 화살을 사용해야 한다.
따라서 모든 화살의 위치를 기억하며 풍선마다 해당 위치의 화살이 있는지 확인하면 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val arrows = IntArray(1000001)
    repeat(r()) {
        val height = r()
        if (arrows[height] > 0) {
            arrows[height] -= 1
        }
        arrows[height - 1] += 1
    }
    print(arrows.sum())
}

/*

*/