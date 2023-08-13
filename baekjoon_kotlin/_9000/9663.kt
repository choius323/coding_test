/*

9663번 - N-Queen
https://www.acmicpc.net/problem/9663

브루트포스 문제이며 재귀 함수를 사용했다.
1. 한 줄에는 하나의 퀸만 들어갈 수 있으므로 다음 재귀함수위 시작은 y+1이다.
2. y+1부터 시작하기 때문에 x는 처음(0)부터 탐색하면 된다.
3. Boolean 배열 3개로 퀸의 위치를 확인한다.

n==4 일 때,
x+y는
0 1 2 3
1 2 3 4
2 3 4 5
3 4 5 6
이므로 슬래시 방향을 체크 할 수 있고
x-y+n-1은
3 4 5 6
2 3 4 5
1 2 3 4
0 1 2 3
이므로 역슬래시 방향을 체크 할 수 있다.

*/

package baekjoon_kotlin._9000

fun main() {
    val n = readLine()!!.toInt()
    val col = BooleanArray(n) // 같은 열에 있는지 확인
    val slash = BooleanArray(2 * n - 1) // 슬래시(/) 방향에 이미 있는지 확인
    val slashR = BooleanArray(2 * n - 1) // 역슬래시(\) 방향에 이미 있는지 확인

    fun re(x: Int, y: Int, b: Boolean) {
        col[x] = b
        slash[x + y] = b
        slashR[x - y + n - 1] = b
    }

    fun put(y: Int): Int {
        return if (y == n) 1
        else {
            var count = 0
            for (x in 0 until n) {
                if (!col[x] && !slash[x + y] && !slashR[x - y + n - 1]) {
                    re(x, y, true)
                    count += put(y + 1)
                    re(x, y, false)
                }
            }
            count
        }
    }
    print(put(0))
}

//import kotlin.math.abs
//
//fun main() {
//    val n = readLine()!!.toInt()
//    val queen = java.util.LinkedList<Pair<Int,Int>>() // 퀸의 위치 저장(x,y)
//    var answer = 0
//
//    fun put(ny: Int) {
//        if (ny == n) answer += 1
//        else if (ny < n) {
//            for (nx in 0 until n) {
//                var isPut = true // 겹치는지 여부 확인
//                for ((x, y) in queen) {
//                    if (nx == x || abs(nx - x) == abs(ny - y)) { // x좌표가 같거나, 대각선에 있거나
//                        isPut = false
//                        break
//                    }
//                }
//                if (isPut) { // 겹치는게 없다면
//                    queen.add(nx to ny)
//                    put(ny + 1)
//                    queen.removeLast()
//                }
//            }
//        }
//    }
//
//    put(0)
//    print(answer)
//}

/*

*/