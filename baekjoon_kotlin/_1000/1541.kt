package baekjoon_kotlin._1000/*

1541번 - 잃어버린 괄호
https://www.acmicpc.net/problem/1541

- 이후의 값은 모두 빼주면 된다.
map과 lambda 함수를 잘 활용해보자.

 */

fun main() {
    val str = readLine()!!
    val sb = StringBuilder()
    var minus = str.indexOf('-')
    minus = if (minus != -1) minus else str.length
    var answer = 0
    str.forEachIndexed { index, c ->
        if (c.compareTo('+') == 0 || c.compareTo('-') == 0) {
            answer += if (index <= minus) sb.toString().toInt() else -sb.toString().toInt()
            sb.clear()
        } else {
            sb.append(c)
        }
    }
    answer += if (minus == str.length) sb.toString().toInt() else -sb.toString().toInt()

    println(answer)
    cal()
}

private fun cal() =
    println(readLine()!!.split("-").map { it.split("+").sumOf { x -> x.toInt() } }.reduce { a, b -> a - b })