/*

9012번 - 괄호
https://www.acmicpc.net/problem/9012

Stack을 활용해서 '('가 들어오면 push를 하고 ')'가 들어오면 pop을 하거나 NO를 출력하면 된다.
끝까지 확인한 뒤에 stack에 남아있는 게 있으면 NO, 없으면 YES를 출력한다.
Kotlin의 ArrayDeque는 양방향 큐이므로 stack으로 사용 가능하지만 Java의 Stack에 비해 속도가 느리고 메모리도 많이 사용한다.

추가로 stack의 push와 pop, size만 사용하기 때문에 stack 대신 count 변수 하나로 대체가 가능하다.

*/

//Stack 사용
//fun main() = System.`in`.bufferedReader().run {
//    val sb = StringBuilder()
//    val stack = java.util.Stack<Char>()
//    repeat(readLine().toInt()) {
//        stack.clear()
//        for (c in readLine()) {
//            when (c) {
//                '(' -> stack.add(c)
//                ')' -> {
//                    if (stack.isEmpty()) {
//                        sb.appendLine("NO")
//                        return@repeat
//                    } else
//                        stack.pop()
//                }
//            }
//        }
//        sb.appendLine(if (stack.isEmpty()) "YES" else "NO")
//    }
//    print(sb)
//}

fun main() = System.`in`.bufferedReader().run {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        var count = 0
        for (c in readLine()) {
            when (c) {
                '(' -> count++
                ')' -> {
                    if (count == 0) {
                        sb.appendLine("NO")
                        return@repeat
                    } else count -= 1
                }
            }
        }
        sb.appendLine(if (count == 0) "YES" else "NO")
    }
    print(sb)
}

/*
6
((
))
())(()
(()
)(
))((
*/