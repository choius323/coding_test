/*

2527번 - 직사각형
https://www.acmicpc.net/problem/2527

c와 d를 먼저 분류하고 b, a 순으로 분류를 했다.
c, d는 겹치는 조건이 없기 때문에 순서가 상관이 없지만 b를 d보다 먼저 하면 다르게 나온다.
c는 4가지 경우이고 x나 y좌표가 같은 점이 2개 있으면 된다.
d는 x<p,y<q 이므로 서로 다른 사각형의 x와 p, y와 q의 관계를 이용하면 된다.
b는 b자체의 조건 만으로는 d가 나올 수 있지만 만나지 않는 경우를 미리 제거했기 때문에 x와 p, y와 q 중에 같은 것이 하나라도 있으면 b이다.
나머지는 전부 a이다. a는 조건이 굉장히 다양해지기 때문에 따로 체크하지 않고 else로 두는 것이 좋다.

*/

package baekjoon_kotlin._2000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Rect(val x: Int, val y: Int, val p: Int, val q: Int)

    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    repeat(4) {
        val r1 = Rect(i(), i(), i(), i())
        val r2 = Rect(i(), i(), i(), i())

        println(
            when {
                (r1.x == r2.p || r1.p == r2.x) && (r1.y == r2.q || r1.q == r2.y) -> "c"
                r2.p < r1.x || r2.x > r1.p || r2.q < r1.y || r2.y > r1.q -> "d"
                r1.x == r2.p || r1.p == r2.x || r1.y == r2.q || r1.q == r2.y -> "b"
                else -> "a"
            }
        )
//        println(
//            if ((r1.x == r2.p || r1.p == r2.x) && (r1.y == r2.q || r1.q == r2.y)) "c"
//            else if (r2.p < r1.x || r2.x > r1.p || r2.q < r1.y || r2.y > r1.q) "d"
//            else if (r1.x == r2.p || r1.p == r2.x || r1.y == r2.q || r1.q == r2.y) "b"
//            else "a"
//        )
    }
}

/*
3 10 50 60 100 100 200 300
45 50 600 600 400 450 500 543
11 120 120 230 50 40 60 440
35 56 67 90 67 80 500 600

1 1 10 10 1 11 10 12
1 3 5 4 5 2 8 7
0 0 100 100 100 100 200 300
1 1 10 10 1 2 5 8

d
a
a
b

d
b
c
a

*/