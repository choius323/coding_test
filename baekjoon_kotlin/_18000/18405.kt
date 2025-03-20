package baekjoon_kotlin._18000

/*

18405번 - 경쟁적 전염
https://www.acmicpc.net/problem/18405
분류 : 구현, 그래프 이론, 그래프 탐색, 너비 우선 탐색

번호가 낮은 바이러스부터 Deque에 넣은 뒤 매 시간마다 바이러스가 퍼지게 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Virus(val num: Int, val x: Int, val y: Int)

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val r = { nextToken();nval.toInt() }
    val n = r()
    val k = r()
    val viruses = ArrayDeque<Virus>()
    val area = Array(n) { y ->
        IntArray(n) { x ->
            val virusNum = r()
            if (virusNum > 0) viruses.addLast(Virus(virusNum, x, y))
            virusNum
        }
    }
    viruses.sortBy(Virus::num)
    val s = r()
    val x = r() - 1
    val y = r() - 1
    var time = 0
    while (time < s) {
        time++
        repeat(viruses.size) {
            val virus = viruses.removeFirst()
            for(d in 0..3) {
                val nx = virus.x + dx[d]
                val ny = virus.y + dy[d]
                if(nx !in 0 until n || ny !in 0 until n || area[ny][nx] != 0) continue
                viruses += Virus(virus.num, nx, ny)
                area[ny][nx] = virus.num
            }
        }
    }
    print(area[x][y])
}

/*

*/