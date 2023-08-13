package baekjoon_kotlin._10000

/*

10989번 - 수 정렬하기 3
https://www.acmicpc.net/problem/10989

모든 숫자를 입력받으며 크기가 10001인 배열에 각 숫자가 나온 횟수를 저장한다.
그리고 배열을 탐색하며 각 숫자가 나온 횟수만큼 그 숫자를 출력한다.
"내용".repeat(0)은 내용이 없기 때문에 나오지 않은 숫자는 출력되지 않는다.

*/

fun main() = System.`in`.bufferedReader().run {
    val count = IntArray(10001)
    val bw = System.out.bufferedWriter()
    repeat(readLine().toInt()) { count[readLine().toInt()]++ }
    for (i in 1..10000) bw.write("$i\n".repeat(count[i]))
    bw.flush()
}

/*

*/