package baekjoon_kotlin._14000

/*

14003번 - 가장 긴 증가하는 부분 수열 5
https://www.acmicpc.net/problem/14003
분류 : 이분 탐색, 가장 긴 증가하는 부분 수열: o(n log n)

이분 탐색으로 증가 부분 수열을 찾는다.
증가 부분 수열은 각 위치에 올 수 있는 숫자 리스트를 저장한다.
그 후에 증가 수열을 거꾸로 확인하며 이 전에 나온 가장 큰 수보다 작으면서 현재 위치에 올 수 있는 가장 큰 수를 배열에 저장한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val list = mutableListOf<MutableList<Int>>()
    repeat(r()) {
        val num = mutableListOf(r())
        val index = list.binarySearch(num, comparator = compareBy { it.last() }).let {
            if (it >= 0) it else -it - 1
        }
        if (index < list.size) {
            list[index].addAll(num)
        } else {
            list.add(num)
        }
    }
    val sb = StringBuilder().appendLine(list.size)
    var last = Int.MAX_VALUE
    val reverse = IntArray(list.size)
    for (i in list.indices.reversed()) {
        val index = minOf(list[i].lastIndex, list[i].binarySearch(last - 1, compareBy { -it }).let {
            if (it >= 0) it else -it - 1
        })
        val num = list[i][index]
        reverse[i] = num
        last = num
    }
    for (i in list.indices) {
        sb.append(reverse[i]).append(' ')
    }
    println(sb)
}

/*

*/