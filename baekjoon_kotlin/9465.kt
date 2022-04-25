/*

9465번 - 스티커
https://www.acmicpc.net/problem/9465

DP를 활용하는 문제이고, 왼쪽부터 차례대로 위아래의 최대 값을 저장하면 된다.
이 문제에서는 이전 arr의 값을 불러올 필요가 없으므로 dp배열을 따로 만들지 않아도 된다.
또, 직전 열의 최대 값은 현재 열의 위아래 칸이 서로 갖고 있기 때문에 최대값은 항상 마지막에 연산한 제일 오른쪽 열 중 하나가 된다.
위아래 행의 연산 순서는 서로 영향을 주지 않기 때문에 상관없다.

처음에는 윗줄을 먼저 채우는 방식으로 해봤지만, 아랫줄을 채울 때 붙어있는 것들을 확인할 수 없어서 위에 있는 방식으로 했다.

*/

package baekjoon_kotlin


fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }
    repeat(i()) {
        val n = i()
        val arr = Array(2) { IntArray(n) { i() } }
        if (n > 1) {
            arr[0][1] += arr[1][0]
            arr[1][1] += arr[0][0]
        }
        for (i in 2 until n) {
            arr[0][i] += maxOf(arr[1][i - 1], arr[1][i - 2])
            arr[1][i] += maxOf(arr[0][i - 1], arr[0][i - 2])
        }
        println(maxOf(arr[0][n - 1], arr[1][n - 1]))
    }
}

//import kotlin.math.max
//
//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    fun i(): Int {
//        nextToken()
//        return nval.toInt()
//    }
//    repeat(i()) {
//        val n = i()
//        val arr = IntArray(n * 2) { i() }
//        if (n > 1) {
//            arr[1] += arr[n]
//            arr[n + 1] += arr[0]
//        }
//        for (i in 2 until n) {
//            arr[i] += max(arr[n + i - 1], arr[n + i - 2])
//            arr[n + i] += max(arr[i - 1], arr[i - 2])
//        }
//        println(max(arr[n - 1], arr[2 * n - 1]))
//    }
//}

/*

*/