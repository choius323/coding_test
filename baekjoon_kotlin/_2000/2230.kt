package baekjoon_kotlin._2000

/*

2230번 - 수 고르기
https://www.acmicpc.net/problem/2230
분류 : 정렬, 두 포인터

모든 수를 오름차순으로 정렬한 뒤 투 포인터를 활용해 차이가 M이상이 되는 가장 가까운 지점을 계속 찾는다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val nums = IntArray(n) { r() }.sortedArray()
    var minDiff = Int.MAX_VALUE
    var point1 = 0

    for (point2 in nums.indices) {
        while (point1 <= point2 && nums[point2] - nums[point1] >= m) {
            point1++
        }
        point1--

        if (point1 >= 0) {
            val diff = nums[point2] - nums[point1]
            if (diff >= m) {
                minDiff = minOf(minDiff, diff)
            }
        } else {
            point1 = 0
        }
    }

    print(minDiff)
}

/*
3 3
1
5
3

4


5 3
1
2
3
4
5

3
*/