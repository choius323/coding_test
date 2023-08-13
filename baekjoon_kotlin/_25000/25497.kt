package baekjoon_kotlin._25000/*

25497번 - 기술 연계마스터 임스
https://www.acmicpc.net/problem/25497

문자를 모두 입력받으며 s와 l이 나오면 각각의 변수에 1을 더하고 k와 r이 나오면 그 값을 빼주면 된다.
S 전에 K가 나오거나 L 전에 R이 나오면 입력을 종료하고 현재까지 확인한 기술의 수를 출력한다.

*/

fun main() = System.`in`.bufferedReader().run {
    var count = 0
    var l = 0
    var s = 0
    readLine()
    while (ready()) when (read().toChar()) {
        in '1'..'9' -> count++
        'S' -> s++
        'L' -> l++
        'K' -> if (s > 0) {
            count++
            s--
        } else break

        'R' -> if (l > 0) {
            count++
            l--
        } else break
    }
    print(count)
}

/*

*/