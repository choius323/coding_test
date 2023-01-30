package mondaychallange.week4

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken(); nval.toInt() }
    var n = r()
    val m = r()
    val queue = ArrayDeque<Int>()
    repeat(m) {
        r()
        when (sval[0]) {
            'd' -> {
                n += r()
                repeat(queue.size) {
                    val p = queue.removeFirst()
                    if (p <= n) n -= p
                    else queue.add(p)
                }
            }
            'p' -> {
                val p = r()
                if (p <= n) n -= p
            }

            'r' -> {
                queue.add(r())
                repeat(queue.size) {
                    val p = queue.removeFirst()
                    if (p <= n) n -= p
                    else queue.add(p)
                }
            }
        }
    }
    print(n)
}