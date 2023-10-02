package baekjoon_kotlin._1000

/*

1253번 - 좋다
https://www.acmicpc.net/problem/1253
분류 : 자료, 구조정렬, 이분 탐색, 해시를 사용한 집합과 맵, 두 포인터

모든 숫자를 확인하며 다른 수 2개의 합으로 만들 수 있는지 확인한다.
투 포인터를 사용해서 왼쪽, 오른쪽 끝부터 탐색하고 i번째 수를 탐색할 때는 start와 end는 i가 되지 않도록 설정한다.
start, end 숫자의 합 sum이 i번째 숫자보다 작으면 더 큰 값을 더해야 하므로 start++, 작으면 end--, 같으면 answer++ 하고 다음 숫자를 확인한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val nums = IntArray(n) { r() }.sortedArray()
    var answer = 0

    for (i in 0 until n) {
        var start = 0
        var end = n - 1
        while (start < end) {
            val sum = nums[start] + nums[end]
            when {
                start == i -> start++
                end == i -> end--
                sum < nums[i] -> start++
                sum > nums[i] -> end--
                else -> {
                    answer++
                    break
                }
            }
        }
    }
    print(answer)
}

/*

*/