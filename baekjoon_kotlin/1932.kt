/*

1932번 - 정수 삼각형
https://www.acmicpc.net/problem/1932

DP를 활용하는 문제이고, DFS로 하면 경우의 수가 2^(n-1)이기 때문에 시간 복잡도가 지수로 나온다.(마지막 선택이 2^(n-1)개)
위에서 왼쪽, 오른쪽 중 하나를 고를 수 있다는 말은 아래에서 보면 왼쪽, 오른쪽 중 하나의 최대값이 내려온 다는 뜻이다.
따라서 이전 값의 i-1, i 중에 최대값을 골라서 이번 값을 더해주면 된다.

피라미드의 크기를 미리 알고 있기 때문에 추가가 많이 발생하는 ArrayList나 MutableList가 IntArray에 비해서 느렸다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val answer = IntArray(n + 1)
    var lastAnswer = IntArray(n + 1)

    for (a in 1..n) {
        for (b in 1..a) {
            answer[b] = kotlin.math.max(lastAnswer[b - 1], lastAnswer[b]) + i()
        }
        lastAnswer = answer.clone()
    }
    print(answer.maxOrNull())
}

/*

*/