package baekjoon_kotlin._2000

/*

2212번 - 센서
https://www.acmicpc.net/problem/2212
분류 : 그리디 알고리즘, 정렬

센서의 좌표를 기준으로 정렬해서 각 센서 사이의 거리를 모두 구한다.
구한 거리를 정렬한 뒤 가장 큰 수 k-1개를 제거한 뒤 모두 더하면 정답이다.

6
2
1 6 9 3 6 7
이 주어질 때 좌표로 정렬하면 [1, 3, 6, 6, 7, 9]가 된다.
그러면 센서 간 거리는 [2, 3, 0, 1, 2]가 되고 이를 다시 정렬하면 [0, 1, 2, 2, 3]이다.
여기서 집중국을 k개 세울 수있기 때문에 센서 간 거리가 가장 먼 3-6을 제외하고 1-3, 6-6-7-9 센서 사이에 놓으면 거리의 합이 가장 작다.
3개를 놓을 수 있다면 1, 3이나 7, 9에 1개를 추가로 연결하면 된다.
이런 방식으로 거리가 가장 먼 센서를 제외하는 방식으로 k-1개를 제외한 값의 합이 총 거리이다.


참고: https://dong-gas.tistory.com/32

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val k = r()
    val posArray = IntArray(n) { r() }.sortedArray()
    val distArray = IntArray(n - 1) { posArray[it + 1] - posArray[it] }.sortedArray()
    print(distArray.dropLast(k - 1).sum())
}


/*
6
2
1 6 9 3 6 7

1 3 6 6 7 9
0 1 2 2 3

 */