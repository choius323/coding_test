/*

5597번 - 과제 안 내신 분..?
https://www.acmicpc.net/problem/5597

크기가 31인 배열을 만들어서 1~30을 각 학생이 과제를 냈는지 확인한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val check = BooleanArray(31)
    repeat(28) { check[r()] = true }
    repeat(30) { if (!check[it + 1]) println(it + 1) }
}

/*

*/