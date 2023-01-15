/*

1371번 - 가장 많은 글자
https://www.acmicpc.net/problem/1371

모든 글자를 확인하며 각 글자가 나온 횟수를 저장하고 max 값을 따로 저장한다.
그 뒤에 나온 횟수를 저장한 배열을 돌며 max와 같은 횟수로 나온 글자를 출력한다.

*/

fun main() = System.`in`.bufferedReader().run {
    val count = IntArray(26)
    var max = 0
    while (ready()) {
        val c = read() - 'a'.code
        if (c >= 0) {
            count[c]++
            max = maxOf(max, count[c])
        }
    }
    count.forEachIndexed { idx, cnt -> if (cnt == max) print((idx + 'a'.code).toChar()) }
}

/*

*/