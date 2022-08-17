/*

13900번 - 순서쌍의 곱의 합
https://www.acmicpc.net/problem/13900

중복이 없고 순서가 없기 때문에 조합(combination)을 사용해서 모든 경우의 합을 구한다.
a b c가 있으면 a*b + a*c + b*c이며 입력 순서대로 묶으면 (0)*a + (a)*b + (a+b)*c 이며 전에 입력된 숫자의 합에 입력된 숫자를 곱한 값을 매번 더하면 답이 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    var answer = 0L
    var sum = 0L
    repeat(r()) {
        val num = r()
        answer += sum * num
        sum += num
    }
    print(answer)
}

/*

*/