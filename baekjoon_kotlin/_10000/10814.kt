package baekjoon_kotlin._10000

/*

10814번 - 나이순 정렬
https://www.acmicpc.net/problem/10814

sort는 기준 속성을 제외하고 원래 순서를 유지한다.
age로만 정렬하면 이름의 순서는 바뀌지 않고 입력된 순서 그대로 유지된다.

*/

data class People(val age: Int, val name: String)

fun main() = System.`in`.bufferedReader().run {
    val sb = StringBuilder()
    List(readLine().toInt()) { readLine().split(" ").run { People(get(0).toInt(), get(1)) } }
        .sortedBy { it.age }
        .forEach { (age, name) -> sb.append("$age $name\n") }
    print(sb)
}

/*

*/