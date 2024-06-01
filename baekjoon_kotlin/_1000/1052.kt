package baekjoon_kotlin._1000

/*

1052번 - 물병
https://www.acmicpc.net/problem/1052
분류 : 수학, 그리디 알고리즘, 비트마스킹

숫자를 2진수로 표현했을 때 1의 개수가 물병을 합쳤을 때 개수이다.

*/

fun main() {
    var answer = 0
    val (n, k) = readln().split(" ").map { it.toInt() }
    while (true) {
        if ((n + answer).countOneBits() <= k) break
        answer++
    }
    print(answer)
}

/*

*/