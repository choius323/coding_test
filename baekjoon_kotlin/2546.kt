/*

2546번 - 경제학과 정원영
https://www.acmicpc.net/problem/2546

n과 m이 헷갈리지 않게 조심하자.
점수 관련 class를 따로 만들어서 관리하는 것도 좋은 방법이다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Double {
        nextToken()
        return nval
    }
    repeat(i().toInt()) {
        val n = i().toInt()
        val m = i().toInt()
        var nAvr = 0f.toDouble()
        var mAvr = 0f.toDouble()
        val nArr = DoubleArray(n) { with(i()) { nAvr += this; this } }
        nAvr /= n
        repeat(m) { mAvr += i() }
        mAvr /= m

        var count = 0
        for (a in nArr) {
            if (a < nAvr && a > mAvr) {
                count += 1
            }
        }
        println(count)
    }
}

/*
4

5 5
100 101 102 103 104
98 100 102 99 101

3 2
99 100 101
98 99

2 1
1 1
1

11 1
2 3 4 5 6 7 8 9 10 11 13
5


1
2 1
1 1
1


*/