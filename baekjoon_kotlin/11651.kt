/*

11651번 - 좌표 정렬하기 2
https://www.acmicpc.net/problem/11651

sortedWith는 파라미터로 compareBy를 사용하면 정렬 기준을 2가지 이상 사용할 수 있다.

*/

fun main() = print(List(readln().toInt()) { readln().split(" ") }
    .sortedWith(compareBy({ it[1].toInt() }, { it[0].toInt() }))
    .joinToString("\n") { "${it[0]} ${it[1]}" })

/*
5
0 4
1 2
1 -2
11 11
3 -3
*/