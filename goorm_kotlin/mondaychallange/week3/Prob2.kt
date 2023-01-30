package mondaychallange.week3

fun main() = System.`in`.bufferedReader().run {
    val sb = StringBuilder()
    var last = -1
    var count = 0
    val board = listOf("1.,?!", "2ABC", "3DEF", "4GHI", "5JKL", "6MNO", "7PQRS", "8TUV", "9WXYZ")
    repeat(readLine().toInt()) {
        when (val num = read() - 49) {
            last -> count++
            else -> {
                if (last != -1) {
                    sb.append(board[last][count % (board[last].length)])
                    count = 0
                }
                last = num
            }
        }
    }
    sb.append(board[last][count % (board[last].length)])
    print(sb)
}