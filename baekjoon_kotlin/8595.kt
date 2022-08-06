/*

8595번 - 히든 넘버
https://www.acmicpc.net/problem/8595

문자 사이의 숫자만 더해서 출력한다.
처음에는 문자열을 입력받고 숫자를 찾을 때마다 StringBuilder에 더하다가 문자가 나오면 StringBuilder에 있는 문자를 숫자로 바꿔서 answer에 더하는 식으로 했다.
하지만 모든 문자열을 입력받는 작업이 메모리를 많이 사용해서 문자를 하나씩 읽고 StringBuilder에 더하는 방식으로 했다.
메모리는 줄었지만 시간은 줄지 않아서 StringBuilder가 아니라 직접 숫자를 더하고 기존의 숫자는 10을 곱하는 방식으로 했다.
이렇게 해야 메모리와 시간을 모두 절약할 수 있었다.

*/

fun main() = System.`in`.bufferedReader().run {
    var num = 0
    var answer = 0L
    repeat(readLine().toInt()) {
        val c = read()
        if (c in '0'.code..'9'.code) num = num * 10 + c - '0'.code
        else if (num != 0) {
            answer += num
            num = 0
        }
    }
    print(answer + num)
}

/*

*/