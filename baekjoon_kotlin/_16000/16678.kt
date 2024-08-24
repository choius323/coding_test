package baekjoon_kotlin._16000

/*

16678번 - 모독
https://www.acmicpc.net/problem/16678
분류 : 그리디 알고리즘, 정렬

1부터 모든 수가 이어지도록 만들수 있도록 하는 것이 목표이다.
1부터 1씩 증가시키며 없는 숫자 x를 찾고, 그보다 큰 숫자 x+1~100000 중 가장 작은 수를 찾는다.
만약 찾지 못하면 모두 이어져있다는 뜻이므로 종료한다.

10만명의 국회의원이 모두 10만점을 갖고 있다면 Int 범위를 초과하기 때문에 Long으로 정답을 저장해야 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val counts = IntArray(100001)
    repeat(r()) {
        counts[r()]++
    }
    var answer = 0L
    var left = 1
    var lastRight = 0
    while (left < counts.size) {
        if (counts[left] > 0) {
            left++
            continue
        }
        var right = maxOf(lastRight, left + 1)
        while (right < counts.size && counts[right] == 0) {
            right++
        }
        if (right >= counts.size) break
        lastRight = right
        counts[right]--
        counts[left]++
        answer += right - left
    }
    print(answer)
}

/*
5
7 3 6 2 4
7 3 6 1 4
7 2 6 1 4
7 2 5 1 4
7 2 5 1 3
7 2 4 1 3
6 2 4 1 3
5 2 4 1 3

7


4
2 5 6 7
1 5 6 7   1
1 2 6 7   3
1 2 3 7   3
1 2 3 4   3

10



1 2 3 4 5 6 7 8
0 0 1 2 0 1 0 2
1 0 0 2 0 1 0 2
1 1 0 1 0 1 0 2
1 1 1 0 0 1 0 2
1 1 1 1 0 0 0 2
1 1 1 1 1 0 0 1
1 1 1 1 1 1 0 0
*/