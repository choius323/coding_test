package baekjoon_kotlin._16000

/*

16936번 - 나3곱2
https://www.acmicpc.net/problem/16936
분류 : 수학, 정렬, 해 구성하기

답이 여러개일 수 있다고 적혀있지만, 실제로 답은 1개라고 한다.
참고 : https://www.acmicpc.net/board/view/80309

모든 순열을 만들며 조건에 맞는 수열을 찾았다.
경우의 수가 항상 1개이기 때문에 방문 처리를 안 해도 된다고 한다.

*/

fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map(String::toLong).toLongArray()
    val answer = LongArray(n)
    var isFilled = false

    fun perm(seq: Int, num: Long) {
        if (seq == n) {
            isFilled = true
            return
        }
        for (i in 0 until n) {
            if (isFilled) return
            val next = nums[i]
            if (num == -1L || num * 2 == next || (num % 3 == 0L && num / 3 == next)) {
                answer[seq] = next
                perm(seq + 1, next)
            }
        }
    }

    perm(0, -1)
    print(answer.joinToString(" "))
}


/*

*/