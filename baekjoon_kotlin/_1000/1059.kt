package baekjoon_kotlin._1000/*

1059번 - 좋은 구간
https://www.acmicpc.net/problem/1059

전체 숫자 중에 n보다 작은 수 중에 가장 큰 값과 n보다 큰 수 중에 가장 작은 값을 찾는다.
min과 n 사이의 개수를 left, max와 n 사이의 개수를 right라고 하면 n을 구간 사이에 넣은 집합은 left*right개, 구간의 끝에 있는 집합이 각각 left, right개이다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val nums = List(r()) { r() }
    val n = r()
    var max = 1000
    var min = 0
    for (it in nums) {
        if (it in n until max) max = it
        if (it in (min + 1)..n) min = it
    }
    if (max - min < 3) return print(0)
    val left = n - min - 1
    val right = max - n - 1
    print(left * right + left + right)
}

/*

*/