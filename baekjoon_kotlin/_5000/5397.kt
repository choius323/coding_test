package baekjoon_kotlin._5000/*

5397번 - 키로거
https://www.acmicpc.net/problem/5397

스택을 2개 사용해서 커서의 왼쪽과 오른쪽에 위치한 것들을 각각의 스택에 넣어준다.
출력은 왼쪽의 스택을 모두 출력하고 오른쪽의 스택을 거꾸로 출력한다.

*/
import java.util.*

fun main() = System.`in`.bufferedReader().run {
    repeat(readLine().toInt()) { _ ->
        val left = Stack<Char>()
        val right = Stack<Char>()
        readLine().forEach {
            when (it) {
                '<' -> if (left.size > 0) right.push(left.pop())
                '>' -> if (right.size > 0) left.push(right.pop())
                '-' -> if (left.size > 0) left.pop()
                else -> left.push(it)
            }
        }
        val sb = StringBuilder()
        left.forEach { sb.append(it) }
        if (right.size > 0) for (i in right.lastIndex downTo 0) sb.append(right[i])
        println(sb)
    }
}

/*
a<b<c<d<e<----f->>>>>>>>-
*/