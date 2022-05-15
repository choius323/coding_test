/*

25196번 - 숲속에서 새 구경하기
https://www.acmicpc.net/problem/25196

브루트포스를 하면서 새가 아무도 안 보일 때 t를 다음 주기로 넘겼다.
setT에서 while문이 아니라 직접 계산하면 더 빠를 것으로 보인다.

함수를 매개변수로 넘기는 방법을 잘 몰라서 식이 보기 안 좋게 됐다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Long {
        nextToken()
        return nval.toLong()
    }

    data class Bird(val v:Long = i(), var s: Long = i(), var e: Long = i())

    fun Bird.isIn(t: Long) = t in s..e
    fun Bird.setT(t: Long) {
        while (t > e) {
            s += v
            e += v
        }
    }

    val a = Bird()
    val b = Bird()
    val c = Bird()

    var t: Long = 0
    val maxT = a.v * b.v * c.v + maxOf(a.e, b.e, c.e)
    while (t <= maxT) {
        if (a.isIn(t) && b.isIn(t) && c.isIn(t)) break
        t++; a.setT(t);b.setT(t);c.setT(t)
        if (!a.isIn(t) || !b.isIn(t) || !c.isIn(t)) {t = maxOf(a.s, b.s, c.s);a.setT(t);b.setT(t);c.setT(t)}
    }
    print(if (t > maxT) -1 else t)
}


/*
2000 1 1
1999 2 2
1998 3 3

7 3 3
4 2 2
5 2 2
*/