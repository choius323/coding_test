/*

1629번 - 곱셈
https://www.acmicpc.net/problem/1629

분할정복을 재귀함수를 사용해 구현했다.
처음엔 직접 제곱을 하며 나머지를 확인했지만 O(n)의 시간이 걸리고 메모리 초과가 발생해서 검색해서 방법을 찾았다.
함수를 직접 그려보는게 이해하는데 많이 도움이 됐다.

a^b%c 를 mod(b)라고 하면
b가 짝수일 때 mod(b)=mod(b/2)^2 % c,
b가 홀수일 때 mod(b)=mod(b/2)^2 % c * mod(1)%c 이다.
재귀 함수의 종료 조건을 count==0으로 두면 1을 반환해도 된다.

변수를 Long으로 두는 이유는 p*a를 했을 때 Int의 범위를 넘기 때문이다. (a < 2147483647)

*/

package baekjoon_kotlin._1000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun l() = (nextToken()).run { nval.toLong() }
    val a = l()
    val b = l()
    val c = l()

    fun mod(count: Long): Long {
        if (count == 1L)
            return a % c
        var p = mod(count / 2)
        p = p * p % c
        if (count % 2L == 1L)
            p = p * a % c
        return p
    }
    print(mod(b))
}

/*
2147483647

2027727829 2147483647 2027727827

2027727829 7 2027727827

*/