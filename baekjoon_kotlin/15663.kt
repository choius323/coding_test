/*

15663번 - N과 M (9)
https://www.acmicpc.net/problem/15663

같은 인덱스를 중복 출력하지 않고, 같은 수를 한 반복문에서 또 출력하지 않으면 된다.(다음 재귀함수에서 출력하는 것은 가능하다.)
처음에는 사용하지 않은 숫자들을 담은 배열을 함수에 매개변수로 줬으나 역시 메모리를 많이 사용하고, 시간 또한 많이 소요됐다.
다음에는 다른 사람의 코드를 참고해서 visited를 함수 바깥에 선언하고 중복으로 출력하지 않게 설정했다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val m = i()
    val sb = StringBuilder()

    //    fun function(arr: List<Int>, str: String, count: Int) {
//        if (count == m) {
//            sb.appendLine(str)
//        } else {
//            var postIndex = -1
//            for (i in arr.indices) {
//                if (postIndex == -1 || arr.getOrElse(postIndex) { -1 } != arr[i]) {
//                    postIndex = i
//                    function(arr.slice(0 until i) + arr.slice(i + 1 until arr.size), str + arr[i] + " ", count + 1)
//                }
//            }
//        }
//    }

    val arr = List(n) { i() }.sorted()
    val visited = BooleanArray(n)
    fun function(lastIndex: Int, str: String, count: Int) {
        if (count == m) {
            sb.appendLine(str)
        } else {
            var lastValue = -1
            for (i in arr.indices) {
                if (i != lastIndex && lastValue != arr[i] && !visited[i]) {
                    lastValue = arr[i]
                    visited[i] = true
                    function(i, str + arr[i] + ' ', count + 1)
                    visited[i] = false
                }
            }
        }
    }

//    function(List(n) { i() }.sorted(), "", 0)
    function(-1, "", 0)
    print(sb)
}

/*
4 3
9 7 9 1
*/