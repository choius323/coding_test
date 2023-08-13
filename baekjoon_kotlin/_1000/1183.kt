package baekjoon_kotlin._1000/*

1183번 - 약속
https://www.acmicpc.net/problem/1183
분류 : 수학, 정렬

|Ai + T - Bi|의 합을 그래프로 그리면 하나의 구간을 기준으로 왼쪽은 기울기가 음수, 오른쪽은 양수이다.
구간은 가장 `Ai - Bi`를 정렬했을 때 가운데에 있는 값을 기준으로 바뀐다.
n이 홀수이면 가운데 구간이 항상 한 점이므로 답은 1이다.
n이 짝수이면 가운데 있는 2개의 값 사이의 차이가 답이 된다.


참고 자료:
https://www.desmos.com/calculator?lang=ko - 그래프 그리는 사이트

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val times = Array(n) { r() - r() }.sortedArray()
    print(if (n % 2 == 1) 1 else times[n / 2] - times[n / 2 - 1] + 1)
}

/*

*/