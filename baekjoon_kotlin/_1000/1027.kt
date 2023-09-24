package baekjoon_kotlin._1000

/*

1027번 - 고층 건물
https://www.acmicpc.net/problem/1027
분류 : 수학, 브루트포스 알고리즘, 기하학

n이 50이므로 n^2의 완전 탐색을 사용해서 풀었다.
한 건물을 기준으로 왼쪽, 오른쪽을 모두 확인하며 더 높은 기울기의 건물이 나올 때 마다 count를 한다.

A건물에서 B건물을 볼 수 있다면 B건물에서도 A건물을 볼 수 있다.
따라서 한쪽 방향만 확인하며 A, B 건물 모두 count를 하면 n^2보다 더 빠르게 구할 수 있다.

*/

fun main() {
    val n = readln().toInt()
    val heights = readln().split(" ").map(String::toInt)

    fun countTower(startIdx: Int, dir: Int): Int {
        var i = startIdx + dir
        var count = 0
        var minGradient = Double.MAX_VALUE
        while(i in 0 until n) {
            val x = kotlin.math.abs(startIdx - i)
            val y = heights[startIdx] - heights[i]
            val gradient = y.toDouble() / x
            if(minGradient > gradient) {
                minGradient = gradient
                count++
            }
            i += dir
        }
        return count
    }

    var answer = 0
    for(i in 0 until n) {
        answer = maxOf(answer, countTower(i, -1) + countTower(i, 1))
    }
    print(answer)
}

/*

*/