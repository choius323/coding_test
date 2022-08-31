/*

2217번 - 로프
https://www.acmicpc.net/problem/2217

로프를 들 수 있는 무게의 오름차순으로 정렬하고 배열을 순회하면, 남은 로프의 수*현재 로프의 무게가 들 수 있는 무게가 된다.
따라서 모든 경우에 무게를 확인하고 최대값을 출력한다.

*/

fun main() = System.`in`.bufferedReader().run {
    val n = readLine().toInt()
    var max = 0
    List(n) { readLine().toInt() }.sorted().forEachIndexed { i, rope -> max = maxOf(max, rope * (n - i)) }
    print(max)
}

/*
4
1
3
10
15
*/