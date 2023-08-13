package baekjoon_kotlin._2000

/*

2504번 - 괄호의 값
https://www.acmicpc.net/problem/2504
분류 : 구현자료, 구조, 스택

괄호와 숫자가 모두 들어갈 수 있는 스택을 만든다.
괄호를 열 때는 스택에 항상 넣고, 닫는 괄호가 나올 때 스택 안에있는 값들과 계산을 해준다.
닫는 괄호가 나오면 스택의 숫자들을 더하며 괄호를 찾고 짝이 맞지 않는 괄호가 나오면 0을 출력하고 종료한다.
맞는 식이면 그 앞에 있는 숫자들을 더하며 바깥쪽 식에 있던 값들을 더한다.
마지막에 스택의 크기가 1이 아니거나 값이 숫자가 아니면 제대로 된 식이 아니기 때문에 0을 출력한다.

*/

fun main() {
    val stack = ArrayDeque<Any>()
    for (c in readln()) {
        if (c == '(' || c == '[') stack.add(c)
        else if (c == ')' || c == ']') {
            var num = if (c == ')') 2 else 3
            while (stack.lastOrNull() is Int) {
                num *= stack.removeLast() as Int
            }
            if (stack.isEmpty() || ((c == ')' && stack.last() == '(') || (c == ']' && stack.last() == '[')).not())
                return print(0)
            stack.removeLast()
            while (stack.lastOrNull() is Int) {
                num += stack.removeLast() as Int
            }
            stack.add(num)
        }
    }
    print(if (stack.size == 1 && stack.first() is Int) stack.first() else 0)
}

/*

*/