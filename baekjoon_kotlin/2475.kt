/*

2475번 - 검증수
https://www.acmicpc.net/problem/2475

(n*n)%10 == (n%10)*(n%10)과 같다.
따라서 5개의 숫자를 위의 과정을 거치고 나온 값을 모두 더하고 그 값을 10으로 나눈 나머지를 출력하면 된다.

*/

//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    val r = { nextToken();nval.toInt() }
//    var sum = 0
//    repeat(5) { sum += r() % 10 * nval.toInt() % 10 }
//    print(sum % 10)
//}

fun main() = print(readln().split(" ").map { it.toInt() % 10 }.sumOf { it * it } % 10)

/*

*/