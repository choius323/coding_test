/*

2556번 - 별 찍기 - 14
https://www.acmicpc.net/problem/2556

안쪽이 꽉찬 n*n 크기의 정사각형을 출력한다.

*/

//fun main()=readln().toInt().let{n->repeat(n){repeat(n){print("*")};println()}}

fun main()=readln().toInt().let{n->repeat(n){println("*".repeat(n))}}

/*

*/