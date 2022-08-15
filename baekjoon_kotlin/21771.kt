/*

21771번 - 가희야 거기서 자는 거 아니야
https://www.acmicpc.net/problem/21771

가희가 베개 위에 있는 경우는 베개가 모두 입력되지 않기 때문에 입력된 P의 개수와 베개의 크기를 비교하면 된다.
BufferedReader의 ready는 값을 더 읽을 수 있는지 확인하고 read는 입력된 값을 하나씩 아스키코드로 읽는다.

*/

fun main() = System.`in`.bufferedReader().run {
    readLine()
    val (_, _, rp, cp) = readLine().split(" ").map { it.toInt() }
    var p = 0
    while (ready()) if (read() == 'P'.code) p++
    print(if (p == rp * cp) 0 else 1)
}

/*

*/