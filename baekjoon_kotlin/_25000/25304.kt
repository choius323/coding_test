package baekjoon_kotlin._25000/*

25304번 - 영수증
https://www.acmicpc.net/problem/25304

처음 숫자를 입력 받고 저장해놓는다.
두번째 숫자만큼 반복하면서 숫자 한 쌍씩 곱해서 더해주면서 처음 숫자와 같은지 확인한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val total = r()
    var sum = 0
    repeat(r()) { sum += r() * r() }
    print(if (sum == total) "Yes" else "No")
}

/*

*/