package baekjoon_kotlin._8000/*

8958번 - OX퀴즈
https://www.acmicpc.net/problem/8958

X를 기준으로 문자열을 나눈 뒤 각 문자열의 길이 l을 이용해 l * (l + 1) / 2를 한 값을 모두 더했다.
다른 방법으로는 O가 나올때마다 count를 1 더하고 sum에 count를 더하며, X가 나오면 count를 0으로 만드는 것이 있다.

*/

fun main() = System.`in`.bufferedReader().run {
    repeat(readLine().toInt()) {
        println(readLine().split("X").sumOf { it.length.let { l -> l * (l + 1) / 2 } })
    }
}

//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    val sb = StringBuilder()
//    nextToken()
//    repeat(nval.toInt()) {
//        var sum = 0
//        var count = 0
//        nextToken()
//        sval.forEach { if (it == 'O') sum += ++count else count = 0 }
//        sb.appendLine(sum)
//    }
//    print(sb)
//}

/*

*/