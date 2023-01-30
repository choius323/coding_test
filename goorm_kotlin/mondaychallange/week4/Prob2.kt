package mondaychallange.week4

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken(); nval.toInt() }
    val n = r()
    var count = 0
    val park = List(n) { MutableList(n) { r() } }
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)
    while (true) {
        var isChange = false
        val next = List(n) { MutableList(n) { 0 } }
        for (y in 0 until n) for (x in 0 until n) {
            if (park[y][x] == 0) {
                for (d in 0..3) {
                    if (x + dx[d] in 0 until n && y + dy[d] in 0 until n) {
                        next[y + dy[d]][x + dx[d]] -= 1
                    }
                }
            }
        }
        for (y in 0 until n) for (x in 0 until n) {
            if (park[y][x] != 0 && next[y][x] != 0) {
                isChange = true
                park[y][x] = maxOf(park[y][x] + next[y][x], 0)
            }
        }
        if (isChange.not()) break
        count++
    }
    print(count)
}