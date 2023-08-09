/*

3079번 - 입국심사
https://www.acmicpc.net/problem/3079
분류 : 이분 탐색, 매개 변수 탐색

직접 시뮬레이션을 돌리며 매초 상황을 확인하면 O(M*T)처럼 오랜 시간이 걸리기 때문에 이분 탐색을 사용했다.
left와 right를 총 심사에 걸리는 시간으로 두고 탐색을 하며, 해당 시간 동안 총 심사 인원을 매개변수 이분 탐색을 했다.
시간의 최솟값을 찾아야 하므로 right를 최대한 mid쪽으로 이동한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toLong() }
    val n = r().toInt()
    val m = r()
    val times = LongArray(n) { r() }
    var left = 0L
    var right = times.max() * m
    while (left + 1 < right) {
        val mid = (left + right) / 2
        val people = times.sumOf { mid / it }
        if (people >= m) {
            right = mid
        } else {
            left = mid
        }
    }
    print(right)
}


/*
3 10
4 5 10000000
*/