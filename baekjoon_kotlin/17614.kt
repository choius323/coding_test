/*

17614번 - 369
https://www.acmicpc.net/problem/17614

브루트 포스로 모든 1~n까지 모든 숫자를 확인하며 문자열로 바꾼 뒤 각 글자가 3, 6, 9인 경우 count를 1 증가시킨다.

*/

fun main() {
    val n = readln().toInt()
    var count = 0
    repeat(n + 1) { num ->
        count += num.toString().count { it == '3' || it == '6' || it == '9' }
    }
    print(count)
}

/*

*/