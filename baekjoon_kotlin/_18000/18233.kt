package baekjoon_kotlin._18000

/*

18233번 - 러버덕을 사랑하는 모임
https://www.acmicpc.net/problem/18233
분류 : 그리디 알고리즘, 브루트포스 알고리즘

우선 p명의 회원을 선택해야 하기 때문에 조합을 사용했다.
20 C 10이 크지 않아서 시간 내에 통과가 가능하다.
그 후 선물을 나눌 때는 그리디 알고리즘을 사용했다.
우선 선택한 모든 회원에게 최소 개수만큼 선물을 나눠주며 수량을 맞출 수 있는지 확인했다.
나눠줄 수 있다면, 각 회원에게 (총 선물의 남은 수량)과 (회원의 최대 수량 - 직전에 준 수량) 중 작은 수를 선물한다.
선택한 모든 회원을 반복한 뒤 선물이 남지 않았다면 그 상태로 답을 출력하며 종료한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Member(val min: Int, val max: Int)

    val r = { nextToken();nval.toInt() }
    val n = r()
    val p = r()
    val e = r()
    val members = List(n) { Member(r(), r()) }
    val counts = IntArray(n)

    fun check(selected: List<Int>): Boolean {
        val array = IntArray(n)
        var remain = e
        for (idx in selected) {
            val quantity = members[idx].min
            array[idx] = quantity
            remain -= quantity
        }
        if (remain < 0) return false

        for (idx in selected) {
            val quantity = minOf(remain, members[idx].max - array[idx])
            array[idx] += quantity
            remain -= quantity
        }
        if (remain > 0) return false

        array.copyInto(counts)
        return true
    }

    fun select(selected: List<Int>, lastIdx: Int): Boolean {
        if (selected.size == p) {
            return check(selected)
        }
        for (idx in lastIdx + 1 until n) {
            if (select(selected + idx, idx)) {
                return true
            }
        }
        return false
    }

    print(if (select(listOf(), -1)) counts.joinToString(" ") else -1)
}

/*
1 2 10
5 15

-1


5 5 30
10 11
15 16
1 1
1 5
1 1


*/