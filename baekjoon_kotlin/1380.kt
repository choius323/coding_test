/*

1380번 - 귀걸이
https://www.acmicpc.net/problem/1380

같은 번호가 2번 등장하면 돌려받은 경우이고, 1번만 등장하면 잃어버린 경우이다.
각 번호 별로 이름을 저장하고
번호와 A, B가 주어지는데 A, B는 사용할 일이 없어서 왜 주는 데이터인지 모르겠다.

*/

fun main() = System.`in`.bufferedReader().run {
    data class Student(val name: String, var isImpounded: Boolean)

    var case = 1
    val sb = StringBuilder()
    while (true) {
        val n = readLine().toInt()
        if (n == 0) return print(sb)
        val students = Array(n) { Student(readLine(), false) }
        repeat(2 * n - 1) {
            val num = readLine().split(" ")[0].toInt() - 1
            students[num].isImpounded = students[num].isImpounded.not()
        }
        sb.appendLine("${case++} ${students.first { it.isImpounded }.name}")
    }
}

/*

*/