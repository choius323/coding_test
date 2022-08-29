/*

2628번 - 종이자르기
https://www.acmicpc.net/problem/2628

자르는 위치를 가로, 세로 따로 저장하고 각자 오름차순으로 정렬한다.
그리고 각 배열을 순회하며 이전 인덱스의 값과 현재 인덱스의 값의 차이가 가장 큰 경우의 값을 서로 곱한다.
각 배열의 처음은 0과 그 값의 차이, 마지막은 총 길이와 그 값의 길이를 최대값과 비교한다.

*/


private fun getMax(arr: List<Int>, len: Int): Int {
    if (arr.isEmpty()) return len
    var max = arr[0]
    for (i in 1..arr.lastIndex)
        max = maxOf(max, arr[i] - arr[i - 1])
    return maxOf(max, len - arr.last())
}

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val width = r()
    val height = r()
    val cutRow = ArrayList<Int>()
    val cutCol = ArrayList<Int>()
    repeat(r()) { (if (r() == 0) cutRow else cutCol).add(r()) }
    cutRow.sort()
    cutCol.sort()
    print(getMax(cutRow, height) * getMax(cutCol, width))
}

/*
10 8
1
0 3
*/