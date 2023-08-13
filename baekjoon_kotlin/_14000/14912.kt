package baekjoon_kotlin._14000

/*

14912번 - 숫자 빈도수
https://www.acmicpc.net/problem/14912

브루트 포스 방식으로 1~n까지 모든 숫자를 확인하며 d가 있을 때마다 count를 1 증가시키며 개수를 확인한다.

*/

//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    val r = { nextToken();nval.toInt() }
//    val n = r()
//    val d = r()
//    var count = 0
//    for (i in 1..n) {
//        var num = i
//        while (num > 0) {
//            if (num % 10 == d) count++
//            num /= 10
//        }
//    }
//    print(count)
//}

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val d = r().digitToChar()
    var count = 0
    for (i in 1..n) for (c in "$i") if (c == d) count++
    print(count)
}

/*

*/