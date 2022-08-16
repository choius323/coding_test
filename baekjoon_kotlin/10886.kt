/*

10886번 -
https://www.acmicpc.net/problem/10886



*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    var c = 0
    var n = 0
    repeat(r()) { if (r() == 1) c++ else n++ }
    print("Junhee is${if (c > n) "" else "not "} cute!")
}

/*

*/