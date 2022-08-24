/*

15904번 - UCPC는 무엇의 약자일까?
https://www.acmicpc.net/problem/15904

글자를 순차적으로 확인하며 U, C, P, C 순으로 글자가 나오는지 확인한다.

*/

fun main() = System.`in`.bufferedReader().run {
    var i = 0
    val str = "UCPC"
    while (ready()) {
        if (read() == str[i].code) i++
        if (i == 4) return print("I love UCPC")
    }
    print("I hate UCPC")
}

/*

*/