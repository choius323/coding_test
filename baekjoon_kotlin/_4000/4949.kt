/*

4949번 - 균형잡힌 세상
https://www.acmicpc.net/problem/4949

스택을 이용해서 (, ), [, ]이 들어올 때 체크해주면 된다.
조건을 신경써서 잘 해주어야 한다.

*/

package baekjoon_kotlin._4000

fun main() = System.`in`.bufferedReader().run {
    var str: String
    val sb = StringBuilder()
    val stack = ArrayDeque<Char>()
    while (true) {
        str = readLine()
        if (str == ".") break
        var isYes = true
        stack.clear()
        str.forEach { c ->
            if (c == '(' || c == '[') stack.add(c)
            else if (c == ')' || c == ']') {
                if (stack.isNotEmpty() && ((stack.last() == '(' && c == ')') || (stack.last() == '[' && c == ']'))) stack.removeLast()
                else {
                    isYes = false
                    return@forEach
                }
            }
        }
        sb.appendLine(if (stack.isEmpty() && isYes) "yes" else "no")
    }
    print(sb)
}

/*
So when I die (the [first] I will see in (heaven) is a score list).
[ first in ] ( first out ).
Half Moon tonight (At least it is better than no Moon at all].
A rope may form )( a trail in a maze.
)()
[(]
(])
)
Help( I[m being held prisoner in a fortune cookie factory)].
([ (([( [ ] ) ( ) (( ))] )) ]).
 .
.



(
.

*/