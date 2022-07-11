/*

9996번 - 한국이 그리울 땐 서버에 접속하지
https://www.acmicpc.net/problem/9996

startsWith, endsWith로 판별하면 된다.
단, 길이에 대한 조건을 추가로 주지 않으면 a*a로 a를 true로 판단하는 등 오류가 생길 수 있다.

*/

fun main() = System.`in`.bufferedReader().run {
    val sb = StringBuilder()
    val n = readLine().toInt()
    val (s, e) = readLine().split("*")
    repeat(n) {
        val str = readLine()
        sb.appendLine(if (str.startsWith(s) && str.endsWith(e) && str.length >= s.length + e.length) "DA" else "NE")
    }
    print(sb)
}

/*
input:
3
a*a
a
aa
aaa

output:
DA
DA
DA

answer:
NE
DA
DA
*/