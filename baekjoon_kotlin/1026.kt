/*

1026번 - 보물
https://www.acmicpc.net/problem/1026

A는 정렬이 가능하고 B는 정렬이 불가능 한게 문제의 조건이지만 순서에 따라 값이 바뀌지 않기 때문에 B도 재정렬 가능하다.
따라서 A는 오름차순, B는 내림차순으로 정렬한 뒤 같은 인덱스의 값끼리 곱하고 sum에 더해주면 된다.

*/

package baekjoon_kotlin

import java.util.*

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val queueA = PriorityQueue<Int>()
    val queueB = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
    repeat(n) {
        queueA.add(i())
    }
    repeat(n){
        queueB.add(i())
    }
    var sum = 0
    repeat(n){
        sum += queueA.poll() * queueB.poll()
    }
    print(sum)

}

/*

*/