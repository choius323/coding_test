package baekjoon_kotlin._2000/*

2156번 - 포도주 시식
https://www.acmicpc.net/problem/2156

DP를 활용하는 문제이고 연속으로 3개 이상 고를 수 없다는 점을 활용해야 한다.
dp i번째 값을 구할 때 i번째 포도주는 마실지 안 마실지 고를 수 있다.
또 dp의 이전 포도주는 몇번을 연속으로 마셨는지 모르기 때문에 dp와 포도주를 연속으로 더할 수 없다.

처음에 작성했던 코드는 dp의 i번째는 i번째 와인을 항상 마신다고 가정했고, dp[i-4]의 값까지 사용해서 dp[i]를 구해야 했다.
하지만 dp[i]에 dp[i-1]의 값만 사용하고 wine[i]를 더하지 않으면 dp[i-4]의 값을 사용하지 않아도 된다.

또 listOf(0) + list(n){입력값}이 배열을 새로 생성해서 메모리와 시간을 많이 소모한다.
따라서 배열을 n+1개로 생성하고 반복문을 사용해서 1..n으로 입력해 주거나 초기화 할 때 인덱스에 따라 초기화 해주는 것이 더 효율적이다.

*/

//처음 작성 코드
//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    val r = { nextToken(); nval.toInt() }
//    val n = r()
//    val wine = listOf(0) + List(n) { r() }
//    val dp = IntArray(n + 1)
//    dp[1] = wine[1]
//    if (n > 1) dp[2] = wine[1] + wine[2]
//    if (n > 2) dp[3] = maxOf(wine[1], wine[2]) + wine[3]
//    for (i in 4..n) {
//        dp[i] = maxOf(dp[i - 2], dp[i - 3] + wine[i - 1], dp[i - 4] + wine[i - 1]) + wine[i]
//    }
//    print(maxOf(dp[n - 1], dp[n]))
//}

// 이후 다른 코드를 참고해서 리팩터링
fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken(); nval.toInt() }
    val n = r()
    val wine = IntArray(n + 1) { if (it > 0) r() else 0 }
    val dp = IntArray(n + 1)
    dp[1] = wine[1]
    if (n > 1) dp[2] = wine[1] + wine[2]
    for (i in 3..n)
        dp[i] = maxOf(dp[i - 1], dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i])
    print(dp[n])
}

/*
6
6
10
13
9
8
1

33


4
1
2
5
1

7



6
5
5
3
1
5
10

25

*/