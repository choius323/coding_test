/*

1920번 - 수 찾기
https://www.acmicpc.net/problem/1920

HashMap의 in은 시간복잡도 O(1)이다.

 */

package baekjoon_kotlin

fun main() {
    val num = hashMapOf<Int, Int>()
    readLine()
    for (i in readLine()!!.split(" ").map { it.toInt() }.toIntArray()) {
        num[i] = 1
    }
    readLine()
    for (i in readLine()!!.split(" ").map { it.toInt() }.toIntArray()){
        println(if(i in num.keys) 1 else 0)
    }
}