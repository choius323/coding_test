/*

11053번 - 가장 긴 증가하는 부분 수열
https://www.acmicpc.net/problem/11053

최장 증가 부분 수열(LIS)을 구현하면 된다.
처음엔 TreeMap을 사용했지만, 기본 배열을 사용하는 것보다 더 오래걸렸다.
HashMap의 탐색 속도가 Array보다 느려서 그런 것으로 보인다.
그래서 배열 2개를 사용 했더니 메모리, 시간 둘 다 줄어드는 것을 볼 수 있었다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val arr = IntArray(n) { i() }
    val dp = IntArray(n) { 1 }
    var ans = 1
    repeat(n) { a ->
        repeat(a) {
            if (dp[a] <= dp[it] && arr[a] > arr[it])
                dp[a] = dp[it] + 1
        }
        if (ans < dp[a]) ans = dp[a]
    }
    print(ans)
}

//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    fun i(): Int {
//        nextToken()
//        return nval.toInt()
//    }
//
//    val arr = java.util.TreeMap<Int, Int>()
//    var answer = 1
//    repeat(i()) {
//        val num = i()
//        if (arr.isEmpty()) arr[num] = 1
//        else {
//            var max = arr[num]?:1
//            for ((key, value) in arr) {
//                if (num > key && max < value + 1) {
//                    max =  value + 1
//                } else if (num <= key){
//                    break
//                }
//            }
//            arr += num to max
//            if (answer < max) answer = max
//        }
//    }
//    println(answer)
//}

/*
7
7 5 3 1 5 7 2

11
5 2 6 5 7 1 5 6 1 5 8

7
1 4 5 2 3 4 5
*/