package baekjoon_kotlin._2000

/*

2485번 - 가로수
https://www.acmicpc.net/problem/2485
분류 : 수학, 정수론, 유클리드 호제법

최소한의 나무를 심어서 모든 가로수의 간격이 같아지려면, 모든 간격의 최대 공약수로 통일해야 한다.
따라서 모든 간격의 최대 공약수를 구하고, 각 간격이 최대 공약수가 되기 위해 심어야 하는 나무의 수를 모두 더한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    fun calcGcd(a: Int, b: Int): Int {
        val (aa, bb) = if (a >= b) b to a else a to b
        return if (bb % aa == 0) aa else calcGcd(bb % aa, aa)
    }

    val n = r()
    var last = r()
    val dist = IntArray(n - 1)
    repeat(n - 1) {
        val now = r()
        dist[it] = now - last
        last = now
    }
    var gcd = dist[0]
    repeat(n - 2) {
        gcd = calcGcd(gcd, dist[it + 1])
    }
    print(dist.sumOf { (it / gcd) - 1 })
}

/*

*/