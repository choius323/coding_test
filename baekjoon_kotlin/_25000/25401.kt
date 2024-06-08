package baekjoon_kotlin._25000

/*

25401번 - 카드 바꾸기
https://www.acmicpc.net/problem/25401
분류 : 수학, 구현, 브루트포스 알고리즘

각 카드의 순서와 값을 좌표로 하는 점으로 바꿨을 때, 점 2개를 정해서 모두 같은 기울기가 되는지 확인했다.

참고: https://ps.mjstudio.net/boj-25401
링크에서는 기울기를 int로 사용했다. 왜 되지?

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val nums = IntArray(n) { r() }
    var answer = Int.MAX_VALUE

    fun getD(idx1: Int, idx2: Int) = (nums[idx2] - nums[idx1]).toDouble() / (idx2 - idx1)

    for (idx1 in nums.indices) {
        for (idx2 in idx1 + 1 until n) {
            var count = 0
            val d1 = getD(idx1, idx2)

            for (idx3 in nums.indices) {
                if (idx1 == idx3 || idx2 == idx3) continue
                val d2 = getD(idx1, idx3)
                if (d1 != d2) count++
            }
            answer = minOf(answer, count)
        }
    }

    print(answer)
}

/*

*/