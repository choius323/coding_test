package baekjoon_kotlin._5000/*

5692번 - 팩토리얼 진법
https://www.acmicpc.net/problem/5692

식은 a_i는 입력받은 숫자의 각 자리이고, i!은 미리 계산해서 배열에 저장한다.
숫자를 입력받으면 각 문자열을 숫자로 바꾼 뒤 계수를 곱하고 그 값들을 모두 더한다.
케이스가 많기 때문에 StringBuilder나 BufferedWriter를 사용해야 한다.

*/

fun main() = System.`in`.bufferedReader().run {
    val fact = IntArray(6) { 1 }
    for (i in 1..5) fact[i] = fact[i - 1] * i
    val bw = System.out.bufferedWriter()
    while (true) {
        val num = readLine()
        if (num == "0") return bw.flush()
        var sum = 0
        for ((i, c) in num.withIndex()) sum += c.digitToInt() * fact[num.length - i]
        bw.write("$sum\n")
    }
}

/*

*/