package baekjoon_kotlin._15000

/*

15831번 - 준표의 조약돌
https://www.acmicpc.net/problem/15831
분류 : 두 포인터

투 포인터를 활용해 우측 포인터를 1칸씩 옮긴 뒤 w, b의 조건에 맞도록 좌측 포인터를 옮겼다.

*/

fun main() {
    val (n, b, w) = readln().split(" ").map { it.toInt() }
    val rocks = readln()
    var answer = 0
    var wc = 0
    var bc = 0
    var left = 0
    var right = 0
    for (c in rocks) {
        if (c == 'W') {
            wc++
        } else {
            bc++
        }
        right++
        while (bc > b && left <= right) {
            if (rocks[left] == 'W') {
                wc--
            } else {
                bc--
            }
            left++
        }
        if (wc >= w) {
            answer = maxOf(answer, right - left)
        }
    }
    print(answer)
}

/*
5 5 0
BBBBB



*/