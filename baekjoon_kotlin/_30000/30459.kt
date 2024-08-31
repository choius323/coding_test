package baekjoon_kotlin._30000

/*

30459번 - 현수막 걸기
https://www.acmicpc.net/problem/30459
분류 : 브루트포스 알고리즘, 정렬, 이분 탐색

모든 말뚝 사이에 현수막을 걸 수 있는지 확인한다.
깃대를 선택할 때는 이분 탐색을 사용해서 R을 넘지 않도록 하는 깃대를 찾는다.
이분 탐색은 제공되는 binarySearch 함수를 사용하고, 만약 함수가 -1을 반환할 경우 모든 깃대가 R보다 큰 현수막을 만든다는 뜻이다.
답을 출력할 때는 Number.toString().format()을 사용하면 1E2와 같은 형식으로 출력되기 때문에 String.format()을 사용해야 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val i = { nextToken();nval.toInt() }
    val n = i()
    val m = i()
    val r = i()
    val piles = IntArray(n) { i() }
    val flags = IntArray(m) { i() }.sortedArray()
    var max = -1
    for (idx1 in 0 until n) {
        for (idx2 in idx1 + 1 until n) {
            val dist = kotlin.math.abs(piles[idx2] - piles[idx1])
            val flagIdx = flags.binarySearch(r * 2 / dist)
            var flag = if (flagIdx < 0) {
                flags.getOrNull(-flagIdx - 2) ?: -1
            } else {
                flags[flagIdx]
            }
            max = maxOf(max, flag * dist)
        }
    }
    print(if (max == -1) -1 else String.format("%.1f", max.toDouble() / 2))
}

/*

*/