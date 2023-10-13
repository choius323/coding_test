package baekjoon_kotlin._12000

/*

12015번 - 가장 긴 증가하는 부분 수열 2
https://www.acmicpc.net/problem/12015
분류 : 이분 탐색, 가장 긴 증가하는 부분 수열: o(n log n)

입력 받는 숫자를 각각 확인하며 그 전에 나왔던 증가 수열 중 들어갈 수 있는 위치에 숫자를 넣어준다.
넣는 위치는 이분 탐색으로 확인한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val list = mutableListOf<Int>()
    repeat(r()) {
        val num = r()
        val index = list.binarySearch(num).let {
            if (it >= 0) it else -it - 1
        }
        if (index < list.size) {
            list[index] = num
        } else {
            list.add(num)
        }
    }
    print(list.size)
}

/*

*/