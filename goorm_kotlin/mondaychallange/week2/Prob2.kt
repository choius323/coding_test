package mondaychallange.week2

fun main() = System.`in`.bufferedReader().run {
    val n = readLine().toInt()
    var count = 0
    var last = 0
    repeat(n) {
        val c = read()
        if (c != last) {
            count++
            last = c
        }
    }
    print(count)
}