/*

2751번 - 수 정렬하기 2
https://www.acmicpc.net/problem/2751

내장 함수를 사용할 경우 BufferedReader와 StringBuilder를 쓰지 않으면 시간 초과가 발생했다.
정렬하지 않는 방법 외에도 abs(i)<=1000000 이므로 크기가 2000001인 Boolean배열을 만들고 True인 값만 출력해주면 O(n)으로 풀이가 가능하다.

*/

package baekjoon_kotlin._2000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val arr = java.util.PriorityQueue<Int>()
    repeat(i()) {
        arr.add(i())
    }
    val sb = StringBuilder()
    repeat(arr.size){
        sb.appendLine(arr.poll())
    }
    print(sb)
}

/*

*/