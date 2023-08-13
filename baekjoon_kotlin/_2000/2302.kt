package baekjoon_kotlin._2000/*

2302번 - 극장 좌석
https://www.acmicpc.net/problem/2302

DP를 활용해 문제를 해결할 수 있다.

규칙은 결론적으로 피보나치와 같이 i번째 항은 i-1번째와 i-2번째 항의 합과 같다.
좌석 3개가 vip없이 이어졌다고 생각할 때 경우의 수는 1-2-3, 2-1-3, 1-3-2 3가지이다.
여기서 옆에 좌석 하나를 더 붙인다고 가정하면, 마지막에 4번을 붙인 1-2-3-4, 2-1-3-4, 1-3-2-4와 마지막에 3번이 있을 때 3과 4가 자리를 바꾼 1-2-4-3, 2-1-4-3이 있다.
4번을 붙이기만 한 경우는 3개가 있을 때의 경우의 수와 같고, 3번과 4번을 바꿨을 때는 2개만 있을 때와 같다.
따라서 n_i = n_(i-1) + n_(i-2)가 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val cases = IntArray(n + 1) { 1 }
    for (i in 2..n) {
        cases[i] = cases[i - 1] + cases[i - 2]
    }
    var answer = 1
    var lastVip = 0
    repeat(m) {
        val vip = r()
        answer *= cases[vip - lastVip - 1]
        lastVip = vip
    }
    print(answer * cases[n - lastVip])
}

/*

*/