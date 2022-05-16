/*

25165번 - 영리한 아리의 포탈 타기
https://www.acmicpc.net/problem/25165

시뮬레이션을 해도 풀 수 있겠지만 계산을 해도 충분하다.
적의 위치, 세로 크기, 방향에 따라 결과가 바뀌고 나머지는 영향을 주지 않는다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken(); return nval.toInt()
    }

    val n = i(); i(); i()
    val d = i()
    val sr = i(); i()
    if (sr == n) {
        if (d != n % 2) print("YES!") else print("NO...")
    } else print("NO...")
}

/*

*/