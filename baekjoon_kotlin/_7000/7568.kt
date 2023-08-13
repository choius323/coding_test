package baekjoon_kotlin._7000/*

7568번 - 덩치
https://www.acmicpc.net/problem/7568

2중 반복문을 사용해서 완전 탐색을 하며 자신보다 랭킹이 더 높은 사람을 찾는다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val people = Array(n) { i() to i() }
    for ((x, y) in people) {
        var rank = 1
        for ((p, q) in people)
            if (x < p && y < q)
                rank++
        print("$rank ")
    }
}

/*
https://gist.github.com/ecaf8b9665e1493e0807e0cc1704350e.git
5
5 5
2 4
3 4
4 4
1 1
*/