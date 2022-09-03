/*

12790번 - Mini Fantasy War
https://www.acmicpc.net/problem/12790

각 스탯의 기본 수치와 증가 수치를 더하고 hp와 mp는 1, atk는 0과 비교해 그 중 최대값을 저장한다.
그리고 각 스탯에 특정 값을 곱하고 모두 더해서 출력한다.

*/

fun main() = System.`in`.bufferedReader().run {
    val bw = System.out.bufferedWriter()
    repeat(readLine().toInt()) {
        val stat = readLine().split(" ").map { it.toInt() }
        val hp = maxOf(1, stat[0] + stat[4])
        val mp = maxOf(1, stat[1] + stat[5])
        val atk = maxOf(0, stat[2] + stat[6])
        val def = stat[3] + stat[7]
        bw.write("${hp + mp * 5 + atk * 2 + def * 2}\n")
    }
    bw.flush()
}

/*

*/