package baekjoon_kotlin._2000/*

2442번 - 별 찍기 - 5
https://www.acmicpc.net/problem/2442

1~n층을 출력할 때 i층은 n-i개의 공백과 2*i-1개의 *로 이루어져 있다.

*/

//fun main() {
//    val n = readln().toInt()
//    val sb = StringBuilder()
//    for (i in 1..n) {
//        repeat(n-i){sb.append(' ')}
//        repeat(2*i-1){sb.append('*')}
//        sb.appendLine()
//    }
//    print(sb)
//}

//fun main()=readln().toInt().let{n->repeat(n){println(" ".repeat(n-it-1)+"*".repeat(2*(it+1)-1))}}

fun main()=readln().toInt().let{n->for(i in 1..n)println(" ".repeat(n-i)+"*".repeat(2*i-1))}

/*

*/