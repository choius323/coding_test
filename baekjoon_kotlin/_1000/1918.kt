/*

1918번 - 후위표기식
https://www.acmicpc.net/problem/1918

연산자를 입력받으면 스택에 넣고 우선순위에 맞춰서 출력해준다.

참고 링크:
https://runestone.academy/ns/books/published/pythonds/BasicDS/InfixPrefixandPostfixExpressions.html
https://blog.naver.com/PostView.naver?blogId=tipsware&logNo=222560727262&categoryNo=0&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=menu

*/

package baekjoon_kotlin._1000

fun main() = System.`in`.bufferedReader().run {
    val input = readLine()
    val sb = StringBuilder()
    val stack = ArrayDeque<Char>()
    val op = hashMapOf('(' to 0, '*' to 1, '/' to 1, '+' to 2, '-' to 2)
    for (c in input) {
        when (c) {
            in 'A'..'Z' -> sb.append(c)
            ')' -> while (true) {
                val s = stack.removeLast()
                if (s == '(') break
                else sb.append(s)
            }
            else -> while (true) {
                if (stack.isNotEmpty() && stack.last() != '(' && op[stack.last()]!! <= op[c]!!) {
                    sb.append(stack.removeLast())
                } else {
                    stack.add(c)
                    break
                }
            }
        }
    }
    while (stack.isNotEmpty()) sb.append(stack.removeLast())
    print(sb)
}

/*
A+B-C

AB+C-


A*B/C

AB*C/


A+B*C

ABC*+


A+B*C-D/E

ABC*+DE/-


A+B*C+D
ABC*+D+
*/