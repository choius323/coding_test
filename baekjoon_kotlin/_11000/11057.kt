/*

11057번 - 오르막 수
https://www.acmicpc.net/problem/11057

DP와 (A+C)% = (A%C + B%C)%C 인 것을 사용해서 해결한다.
배열을 1~2개 사용하는 것과 n개 만큼 사용하는 것은 속도와 메모리에 큰 차이가 없었다.

모듈러 연산의 성징과 증명 :
https://sexycoder.tistory.com/66

*/

package baekjoon_kotlin._11000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    nextToken()
    val n = nval.toInt()
    val answer = Array(n) { IntArray(10) }
    answer[0].fill(1)
    repeat(n - 1) {
        answer[it + 1][9] = answer[it][9]
        for (i in 8 downTo 0)
            answer[it + 1][i] = (answer[it + 1][i + 1] + answer[it][i]) % 10007
    }
    print(answer[n - 1].sum() % 10007)
}

/*

*/