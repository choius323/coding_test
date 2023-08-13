package baekjoon_kotlin._10000

/*

10773번 - 제로
https://www.acmicpc.net/problem/10773

0이 아닌 숫자를 입력받으면 배열에 저장하고, 0을 입력받을 때 배열에서 제거하며 입력받는 숫자들을 저장한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    var answer = 0
    val call = mutableListOf<Int>()
    repeat(r()) {
        val num = r()
        if (num == 0) {
            answer -= call.removeLast()
        } else {
            call.add(num)
            answer += call.last()
        }
    }
    print(answer)
}

/*

*/