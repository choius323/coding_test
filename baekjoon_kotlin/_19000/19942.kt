package baekjoon_kotlin._19000

/*

19942번 - 다이어트
https://www.acmicpc.net/problem/19942
분류 : 브루트포스 알고리즘, 백트래킹

처음엔 DP를 사용하려 했지만, 조건이 까다로워서 DP 배열을 만들 수 없었다.
따라서 모든 식재료 조합을 만들며 가장 최적의 조합을 찾는 알고리즘을 작성했다.
재귀함수의 종료 조건은 현재 찾은 최소값보다 작으면서 영양소를 만족하거나, 최솟값보다 크면 함수를 종료하도록 했다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Stuff(val p: Int, val f: Int, val s: Int, val v: Int, val c: Int) {
        operator fun plus(other: Stuff) = Stuff(p + other.p, f + other.f, s + other.s, v + other.v, c + other.c)
    }

    val r = { nextToken();nval.toInt() }
    val n = r()
    val (mp, mf, ms, mv) = List(4) { r() }
    val stuffs = List(n) { Stuff(r(), r(), r(), r(), r()) }
    var minPrice = Int.MAX_VALUE
    var minStuffs = listOf<Int>()

    fun checkStuff(stuff: Stuff) = stuff.run {
        c < minPrice && p >= mp && f >= mf && s >= ms && v >= mv
    }

    fun comb(stuff: Stuff, startIndex: Int, selectedIndices: List<Int>) {
        if (checkStuff(stuff)) {
            minPrice = stuff.c
            minStuffs = selectedIndices
            return
        } else if (stuff.c > minPrice) {
            return
        }
        for (index in startIndex until n) {
            comb(stuff + stuffs[index], index + 1, selectedIndices + listOf(index + 1))
        }
    }
    comb(Stuff(0, 0, 0, 0, 0), 0, listOf())

    print(if (minPrice == Int.MAX_VALUE) -1 else "$minPrice\n${minStuffs.joinToString(" ")}")
}

/*

*/