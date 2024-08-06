package baekjoon_kotlin._19000

/*

19539번 - 사과나무
https://www.acmicpc.net/problem/19539
분류 : 수학, 그리디 알고리즘

동시에 1, 2 성장 물뿌리개를 사용해야 하므로 매일 나무의 높이는 3만큼 자란다.

1. 나무 높이의 합계가 3으로 나누어 떨어지지 않는다면 만들 수 없다.
2. 2는 1을 2번 나눠서 줄 수 있다. 따라서 2를 사용할 수 있는 횟수가 전체 날짜보다 많다면 만들 수 있다.(3으로 나누어 떨어지기 때문에 항상 만족한다.)

https://readble-ko.tistory.com/149

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    var count2 = 0
    var sum = 0
    repeat(r()) {
        val height = r()
        sum += height
        count2 += height / 2
    }
    print(if (sum % 3 != 0 || count2 < sum / 3) "NO" else "YES")
}

/*

*/