/*

10093번 - 숫자
https://www.acmicpc.net/problem/10093

숫자가 10^15까지 입력되기 때문에 Long을 사용한다.
a,b 중 어떤 것이 더 클지 모르고 같을 수도 있기 떄문에 예외 처리를 꼼꼼히 해야 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toLong() }
    val bw = System.out.bufferedWriter()
    var a = r()
    var b = r()
    if (a > b) a = b.also { b = a }
    bw.write("${maxOf(b - a - 1, 0)}\n")
    for (i in a + 1 until b) bw.write("$i ")
    bw.flush()
}

/*
1000000000000000 1000000000010000
*/