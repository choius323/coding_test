package baekjoon_kotlin._10000

/*

10807번 - 개수 세기
https://www.acmicpc.net/problem/10807

문자열 비교는 생각보다 빠르다.

*/

fun main() {
    readln()
    val nums = readln().split(" ")
    val v = readln()
    print(nums.count { it == v })
}

/*

*/