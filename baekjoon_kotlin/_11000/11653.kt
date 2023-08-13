package baekjoon_kotlin._11000

/*

11653번 - 소인수분해
https://www.acmicpc.net/problem/11653

n을 1이 될때까지 나누며 m으로 나눠질 때마다 출력한다.
m은 2부터 커지며 n을 나누기 때문에 출력할 때는 항상 소수이다.

*/

fun main() {
    var n = readln().toInt()
    val sb = StringBuilder()
    var m = 2
    while (n > 1)
        if (n%m == 0){
            sb.appendLine(m)
            n /= m
        } else m += 1
    print(sb)
}

/*

*/