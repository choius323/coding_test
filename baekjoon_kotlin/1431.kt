/*

1431번 - 시리얼 번호
https://www.acmicpc.net/problem/1431
분류 : 정렬

sortedWith, compareBy를 통해 문자열을 정렬한 뒤 출력한다.

*/

fun main() = print(
    List(readln().toInt()) { readln() }
        .sortedWith(compareBy({ it.length }, { it.sumOf { it.digitToIntOrNull() ?: 0 } }, { it }))
        .joinToString("\n") { it }
)

/*

*/