/*

11444번 - 피보나치 수 6
https://www.acmicpc.net/problem/11444

행렬 ((1,1),(1,0))을 A, Fn을 n번째 피보나치 수 라고 할 때 A^n = ((Fn+1, Fn), (Fn, Fn-1))이 된다.
따라서 Fn은 A^(n-1)의 (0, 0)이다.

참고 링크:
https://st-lab.tistory.com/252

*/

package baekjoon_kotlin

fun main() = System.`in`.bufferedReader().run {
    val n = readLine().toLong()
    val mod = 1000000007L

    fun LongArray.multi(arr: LongArray): LongArray {
        return longArrayOf(
            (get(0) * arr[0] + get(1) * arr[2]) % mod, (get(0) * arr[1] + get(1) * arr[3]) % mod,
            (get(2) * arr[0] + get(3) * arr[2]) % mod, (get(2) * arr[1] + get(3) * arr[3]) % mod
        )
    }

    fun pow(i: Long): LongArray {
        if (i < 2) return longArrayOf(1L, 1L, 1L, 0L)

        var arr = pow(i / 2)
        arr = arr.multi(arr)
        if (i % 2 == 1L) arr = arr.multi(pow(1))

        return arr
    }

    print(pow(n - 1)[0] % mod)
}

/*
1000000000000000000
999999999999999999
*/