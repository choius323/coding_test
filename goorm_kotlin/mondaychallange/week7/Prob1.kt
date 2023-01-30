package mondaychallange.week7

/*

Prob1번 - UXUI 디자이너

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val events = MutableList(n + 1) { 0 }
    var max = 0
    repeat(m) {
        repeat(r()) {
            events[r()].inc().let { count ->
                max = maxOf(count, max)
            }
        }
    }
    val sb = StringBuilder()
    for (i in n downTo 1) {
        if (events[i] == max) sb.append("$i ")
    }
    print(sb)
}

/*

*/