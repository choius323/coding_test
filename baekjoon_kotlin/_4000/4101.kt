package baekjoon_kotlin._4000/*

4101번 - 크냐?
https://www.acmicpc.net/problem/4101

BufferedWrtier를 사용해서 출력했다.
a와 b를 입력받고 값을 비교한 뒤 출력한다.
마지막 줄에는 두 수가 모두 0이지만 비교하는 수는 항상 양의 정수이므로 a가 0인지만 확인하면 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val bw = System.out.bufferedWriter()
    while (true) {
        val a = r()
        val b = r()
        if (a < 1) return bw.flush()
        else bw.appendLine(if (a > b) "Yes" else "No")
    }
}

/*

*/