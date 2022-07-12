/*

2309번 - 일곱 난쟁이
https://www.acmicpc.net/problem/2309

2중 for문을 사용하며 a, b 인덱스를 제외한 합이 100이 되는지 확인했다.

*/

fun main() = System.`in`.bufferedReader().run {
    val tall = IntArray(9) { readLine().toInt() }.sorted()
    for (a in 0..7) for (b in a + 1..8) {
        val filter = tall.filterIndexed { i, _ -> i != a && i != b }
        if (filter.sum() == 100) {
            filter.forEach { println(it) }
            return
        }
    }
}

/*

*/