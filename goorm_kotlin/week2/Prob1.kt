package goorm_kotlin.week2

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken(); nval.toInt() }
    val sb = StringBuilder()
    repeat(r()) { _ ->
        var sum = 0
        val n = r()
        val scores = List(n) { n * r().also { sum += it } }.sorted()
        val index = scores.search(sum)
        println("$scores $index $sum")
        sb.append((if (index >= 0) n - index else n + index + 1).toInt()).appendLine("/$n")
    }
    print(sb)
}

fun List<Int>.search(target: Int): Int {
    var start = 0
    var end: Int = size - 1
    var mid: Int
    while (start <= end) {
        mid = (start + end) / 2
        if (get(mid) < target) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return start
}
