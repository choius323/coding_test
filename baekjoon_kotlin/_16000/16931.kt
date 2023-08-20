/*

16931번 - 겉넓이 구하기
https://www.acmicpc.net/problem/16931

각 칸에 놓인 블럭 기둥의 위아랫면과 상하좌우에 있는 기둥의 높이 차를 더하면 된다.
단, 높이 차를 더할 때는 현재 기둥이 더 높을 때만 더해야 한다.
이 과정을 모든 기둥에 반복하면 된다.

*/

package baekjoon_kotlin._16000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val m = i()
    val block = Array(n) { IntArray(m) { i() } }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    var answer = n * m * 2

    for (y in 0 until n) for (x in 0 until m) {
        repeat(4) {
            val nx = x + dx[it]
            val ny = y + dy[it]
            answer += if (nx in 0 until m && ny in 0 until n)
                maxOf(block[y][x] - block[ny][nx], 0)
            else block[y][x]
        }
    }
    print(answer)
}

/*
2 1
2
1
*/