package baekjoon_kotlin._11000

/*

11098번 - 첼시를 도와줘!
https://www.acmicpc.net/problem/10865

가장 비싼 선수의 가격과 이름을 따로 저장하고 매번 가격을 입력받으며 조건에 따라 이름을 갱신한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    repeat(r()) {
        var max = 0
        var name = ""
        repeat(r()) {
            val price = r()
            r()
            name = if (max < price) {
                max = price
                sval
            } else name
        }
        println(name)
    }
}

/*

*/