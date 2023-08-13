package baekjoon_kotlin._10000

/*

10886번 - 덱
https://www.acmicpc.net/problem/10866

Deque를 사용하는 문제이다.
StreamTokenizer에 공백이나 단어 글자로 언더바(_)를 추가했다.
속도는 같지만 난이도는 단어로 추가하는 게 더 쉽다.

*/

//단어로 언더바(_) 추가
fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun s(): String {
        nextToken()
        return sval
    }

    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val deque = ArrayDeque<Int>()
    val sb = StringBuilder()
    wordChars(95, 95)
    repeat(i()) {
        sb.appendLine(
            when (s()) {
                "push_front" -> deque.addFirst(i()).run { return@repeat }
                "push_back" -> deque.add(i()).run { return@repeat }
                "pop_front" -> deque.removeFirstOrNull() ?: -1
                "pop_back" -> deque.removeLastOrNull() ?: -1
                "size" -> deque.size
                "empty" -> if (deque.isEmpty()) 1 else 0
                "front" -> deque.firstOrNull() ?: -1
                else -> deque.lastOrNull() ?: -1
            }
        )
    }
    print(sb)
}

//공백으로 언더바(_) 추가
//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    fun s(): String {
//        nextToken()
//        return sval
//    }
//
//    fun i(): Int {
//        nextToken()
//        return nval.toInt()
//    }
//
//    val deque = ArrayDeque<Int>()
//    val sb = StringBuilder()
//    whitespaceChars(95, 95)
//    repeat(i()) {
//        val command = s()
//        sb.appendLine(
//            when (command[0]) {
//                'p' -> {
//                    if (command[1] == 'u') {
//                        if (s()[0] == 'f') deque.addFirst(i())
//                        else deque.add(i())
//                        return@repeat
//                    } else
//                        if (s()[0] == 'f') deque.removeFirstOrNull() ?: -1
//                        else deque.removeLastOrNull() ?: -1
//                }
//                's' -> deque.size
//                'e' -> if (deque.isEmpty()) 1 else 0
//                'f' -> deque.firstOrNull() ?: -1
//                else -> deque.lastOrNull() ?: -1
//            }
//        )
//    }
//    print(sb)
//}

/*

*/