package baekjoon_kotlin._2000

/*

2487번 - 섞기 수열
https://www.acmicpc.net/problem/2487
분류 : 수학, 정수론, 유클리드 호제법, 순열 사이클 분할

각 위치에 있는 카드는 일정 횟수 섞인 후 자신의 자리로 돌아오며, 각 카드가 돌아오는 횟수는 다르다.
카드가 섞이는 위치는 사이클이 존재하며, 한 사이클 안에 있는 모든 카드는 전부 동일한 횟수를 갖는다.
따라서 각 사이클의 횟수를 찾고, 최소공배수를 찾는 것이 답이다.
답은 Int 범위 안에 있지만, LCM을 찾는 과정에서 Int 범위를 넘을 수 있기 때문에 조심해야 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val nums = IntArray(n) { r() - 1 }
    val visited = BooleanArray(n)

    fun recur(num: Int): Int {
        if (visited[num]) {
            return 0
        } else {
            visited[num] = true
            return recur(nums[num]) + 1
        }
    }

    fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a

    fun lcm(a: Int, b: Int) = (a.toLong() * b / gcd(a, b)).toInt()

    print(IntArray(n) { recur(it) }.filter { it != 0 }.reduce(::lcm))
}

/*

*/