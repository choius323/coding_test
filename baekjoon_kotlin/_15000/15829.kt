package baekjoon_kotlin._15000/*

15829번 - Hashing
https://www.acmicpc.net/problem/15829
분류 : 구현, 문자열, 해싱

해시코드를 만드는 기본 방식이다.

*/

fun main() {
    var hash = 0L
    var r = 1L
    readln()
    for (c in readln()) {
        hash += (c.code - 96) * r
        r = r * 31 % 1234567891
    }
    print(hash)
}

/*

*/