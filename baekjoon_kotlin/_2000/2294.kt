package baekjoon_kotlin._2000/*

2294번 - 동전 2
https://www.acmicpc.net/problem/2294

DP를 활용해 모든 합에서 가질 수 있는 최소 동전 수를 저장한다.
배열은 인덱스가 동전 가치의 합이고, 값은 동전의 개수를 의미한다.

같은 동전이 여러번 주어지더라도 배열이 갱신 되지 않고, n이 작기 때문에 무시했다.
배열의 초기값은 동전의 최소 가치인 1원 동전으로만 채울 때 보다 더 큰 k+1로 설정했다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val k = r()
    val counts = IntArray(k + 1) { k + 1 }
    counts[0] = 0
    IntArray(n) { r() }.forEach { value ->
        for (i in counts.indices) {
            if (i - value in 0..k && counts[i - value] + 1 < counts[i]) {
                counts[i] = counts[i - value] + 1
            }
        }
    }
    print(counts.last().takeIf { it != k + 1 } ?: -1)
}

/*

*/