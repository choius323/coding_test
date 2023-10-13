package baekjoon_kotlin._12000

/*

12970번 - AB
https://www.acmicpc.net/problem/12970
분류 : 수학, 그리디 알고리즘, 해 구성하기

n개의 A와 B로 k를 만들 수 있는 지 우선 확인한다.
만들 수 있다면 앞을 A, 뒤를 B로 모두 채우고 A 1개의 위치를 조절하며 k를 만든다.

n = 7
AABBBBA => k = 8
AABBBAB => k = 8 + 1
AABBABB => k = 8 + 2
AABABBB => k = 8 + 3
AAABBBB => k = 8 + 4

참고 링크:
https://velog.io/@abc5259/%EB%B0%B1%EC%A4%80-A%EC%99%80-B

*/

fun main() {
    val (n, k) = readln().split(" ").map(String::toInt)
    if (k == 0) {
        return print("A".repeat(n))
    }

    var a = 1
    while (a * (n - a) < k) {
        if (a > n) return print(-1)
        a++
    }

    val array = CharArray(n) { 'B' }
    array.fill('A', toIndex = a - 1)
    val multi = (a - 1) * (n - a)
    array[n - (k - multi) - 1] = 'A'

    print(array.joinToString(""))
}

/*

*/