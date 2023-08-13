package baekjoon_kotlin._10000

/*

10828번 - 스택
https://www.acmicpc.net/problem/10828

자바의 Stack을 사용하거나 kotlin의 ArrayDeque, ArrayList, Array 등을 사용하면 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val stack = ArrayDeque<Int>()
    val sb = StringBuilder()
    repeat(i()) {
        i()
        sb.appendLine(
            when (sval) {
                "push" -> {
                    stack.add(i())
                    return@repeat
                }
                "pop" -> stack.removeLastOrNull() ?: -1
                "size" -> stack.size
                "top" -> stack.lastOrNull() ?: -1
                else -> if (stack.isEmpty()) 1 else 0
            }
        )
    }
    print(sb)
}

/*

*/