/*

2581번 - 소수
https://www.acmicpc.net/problem/2581

에라토스테네스의 체를 구현했다.
arr의 인덱스가 false면 소수이고 true면 소수가 아니다.
1은 소수가 아니지만 반복문으로 바뀌지 않기 때문에 따로 바꿔줘야 한다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    nextToken()
    val m = nval.toInt()
    nextToken()
    val n = nval.toInt()

    val arr = BooleanArray(n + 1)
    arr[1] = true
    for (i in 2..n / 2) {
        if (!arr[i]) {
            for (switch in i * 2..n step (i)) {
                arr[switch] = true
            }
        }
    }

    var sum = 0
    var min = 0
    for (i in m..n) {
        if (!arr[i]) {
            sum += i
            if (min == 0) min = i
        }
    }
    print(if (min == 0) -1 else "$sum\n$min")
}

/*

*/