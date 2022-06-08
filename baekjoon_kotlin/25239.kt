/*

25239번 - 가희와 카오스 파풀라투스
https://www.acmicpc.net/problem/25239

현재 시각을 저장하고 각 영역별 회복량을 저장한다.1
이벤트 목록은 시간 순으로 들어오기 때문에 끝나기 전 이벤트의 행동만 보면 된다.
행동이 3종류 밖에 없기 때문에 when으로 행동의 마지막 글자만으로 어떤 명령인지 알 수 있다.

*/

package baekjoon_kotlin

fun main() = System.`in`.bufferedReader().run {
    var (h, m) = readLine().split(":").map { it.toInt() }
    val heal = readLine().split(" ").map { it.toInt() }.toIntArray()
    repeat(readLine().toInt()) {
        val input = readLine().split(".", " ")
        if (input[0].toInt() < 60)
            when (input[2].last()) {
                '^' -> heal[h / 2] = 0
                'N' -> m += input[2].slice(0..1).toInt()
                'R' -> h += input[2][0].digitToInt()
            }
        if (m >= 60) h += 1
        m %= 60
        h %= 12
    }
    print(minOf(heal.sum(), 100))
}

/*

*/