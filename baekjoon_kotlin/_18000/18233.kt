package baekjoon_kotlin._18000

/*

18233번 - 러버덕을 사랑하는 모임
https://www.acmicpc.net/problem/18233
분류 : 그리디 알고리즘, 브루트포스 알고리즘



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