/*

10871번 - X보다 작은 수
https://www.acmicpc.net/problem/10871

숫자 목록을 받아서 x보다 작은 것들을 필터링 한 뒤에 출력하면 된다.

*/

fun main() = System.`in`.bufferedReader().run {
    val sb = StringBuilder()
    val x = readLine().split(" ").map { it.toInt() }[1]
    readLine().split(" ").filter { it.toInt() < x }.forEach { sb.append("$it ") }
    print(sb)
}

/*

*/