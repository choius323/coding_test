/*

1058번 - 친구
https://www.acmicpc.net/problem/1058

2-친구는 그래프에서 거리가 2이하인 친구를 의미한다.
여러 방법이 있지만 플로이드-와샬로 모든 노드 간의 거리를 구하고 2이하인 값의 개수를 출력했다.

*/

package baekjoon_kotlin._1000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    nextToken()
    val n = nval.toInt()
    val fr = Array(n) { IntArray(n) { 100 } }
    repeat(n) { fr[it][it] = 0 }

    repeat(n) {
        nextToken()
        sval.forEachIndexed { i, c ->
            if (c == 'Y') fr[it][i] = 1
        }
    }

    for (b in 0 until n) for (a in 0 until n) for (c in 0 until n)
        if (fr[a][c] > fr[a][b] + fr[b][c]) fr[a][c] = fr[a][b] + fr[b][c]

    var answer = 0
    fr.forEach { arr -> answer = maxOf(answer, (arr.filter { it < 3 }.size -1))  }
    print(answer)
}

/*

*/