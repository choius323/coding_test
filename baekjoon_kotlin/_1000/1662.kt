package baekjoon_kotlin._1000/*

1662번 - 압축
https://www.acmicpc.net/problem/1662

문자열을 입력받아 한 글자씩 탐색하며 '('가 나오면 재귀로 안쪽 식의 결과를 계산하고 ')'가 나오면 재귀를 종료하고 값을 반환했다.
`()`같은 입력이 있다고 가정하고 풀었는데 `K(Q)`에서 Q는 문자열이라 내용이 없어도 되지만(빈 문자열) K는 숫자이기 때문에 반드시 있어야 해서 없는 경우였다.

dfs 함수는 괄호 안의 문자열 길이를 반환하게 했다.
'('를 만나면 마지막에 나온 숫자와 재귀로 반환된 값을 곱해서 count에 더하고, 마지막에 나온 숫자는 문자열로 취급하지 않기 때문에 count를 1 낮춘다.
숫자를 찾을 때마다 count에 1을 더하고 lastNum을 갱신한다.

*/

fun main() = System.`in`.bufferedReader().run {
    val input = readLine()
    var index = 0

    fun recur(): Int {
        var count = 0 //문자열 길이
        var lastNum = ' ' //마지막에 나온 숫자
        while (index < input.length) {
            when (val c = input[index++]) {
                //재귀함수*마지막 숫자를 count에 더해주고 숫자를 count에서 사용했으니 1을 뺀다.
                '(' -> count += recur() * lastNum.digitToInt() - 1
                //괄호 안의 문자열 길이를 반환한다.
                ')' -> return count
                else -> {
                    count++
                    lastNum = c
                }
            }
        }
        return count //가장 바깥쪽의 괄호가 없는 경우
    }
    print(recur())
}

/*
1()23

2


2(3)3(4)4

6
*/