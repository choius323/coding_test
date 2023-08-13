/*

1146번 - RGB거리
https://www.acmicpc.net/problem/1146

계단 오르기 문제처럼 생각했었지만 복잡하기만 하고 필요하지 않았다.
색이 3가지 밖에 없기 때문에 집마다 경우의 수는 총 6개(현재 색상 3, 직전 집 색상 2)이므로 직접 계산해도 충분하다.
문제를 보는 시각을 또 넓힐 수 있었고, 여러 시도를 하면서 코틀린에 대한 이해도가 많이 늘었다.

*/

package baekjoon_kotlin._1000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i() = (nextToken()).run { nval.toInt() }
    val n = i()
    val answer = IntArray(3)
    val choice = arrayOf(intArrayOf(1, 2), intArrayOf(0, 2), intArrayOf(0, 1))
    var last = IntArray(3)
    repeat(n) {
        for (i in 0..2) {
            answer[i] = last[choice[i][0]].coerceAtMost(last[choice[i][1]]) + i()
        }
        last = answer.clone()
    }
    print(answer.minOrNull())
}

//fun main() = (System.`in`.bufferedReader()).run {
//    fun IntArray.min(a: Int = 1001, b: Int = 1001): Pair<Int, Int> {
//        val newThis = this.filterIndexed { index, _ -> index != a && index != b }
//        val min = newThis.minOrNull()!!
//        var minIndex = newThis.indexOf(min)
//        if (minIndex >= a) minIndex += 1
//        if (minIndex >= b) minIndex += 1
//        return min to minIndex
//    }
//
//    operator fun Pair<Int, Int>.plus(int: Int) = this.first + int to this.second
//
//    val n = readLine().toInt()
//    val prices = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
//    val answer = Array(n) { 0 to 0 }  // 가격 합, 색(0,1,2)
//    answer[0] = prices[0].min()
//    if (n > 1) {
//        answer[1] = prices[1].min(answer[0].second)
//        answer[1] = answer[1] + answer[0].first
//    }
//
//    for (i in 2 until n) {
//        answer[i] = prices[i].min() + answer[i - 2].first
//        answer[i] = answer[i] + prices[i - 1].min(answer[i].second, answer[i - 2].second).first
//        val comparePair = prices[i].min(answer[i - 1].second) + answer[i - 1].first
//        println("${answer[i]} $comparePair")
//        if (answer[i].first > comparePair.first) answer[i] = comparePair
//    }
//    print(answer.contentDeepToString())
//}

/*
3
1 3 9
1 2 9
3 1 9

5
*/