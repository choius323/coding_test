/*

1927번 - 최소 힙
https://www.acmicpc.net/problem/1927

시간 초과가 발생하진 않았지만 ArrayList보다 ArrayDeque가 조금 더 빠르다.
최소 힙과 최대 힙을 조금 더 구현해 볼 필요가 있다.

 */

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val heap = ArrayDeque<Int>()
    heap.add(0)
    for (i in 1..br.readLine().toInt()) {
        val input = br.readLine().toInt()
        if (input == 0) {
            if (heap.size > 1) {
                sb.append("${heap[1]}\n")
                heap[1] = heap[heap.size - 1]
                heap.removeAt(heap.size - 1)
                var index = 1
                while (index * 2 <= heap.size - 1) {
                    if (index * 2 + 1 <= heap.size - 1 && heap[index] > heap[index * 2 + 1] && heap[index * 2 + 1] < heap[index * 2]) {
                        heap[index] = heap[index * 2 + 1].also { heap[index * 2 + 1] = heap[index] }
                        index = index * 2 + 1
                    } else if (heap[index] > heap[index * 2]) {
                        heap[index] = heap[index * 2].also { heap[index * 2] = heap[index] }
                        index *= 2
                    } else {
                        break
                    }
                }
            } else {
                sb.append("${0}\n")
            }
        } else {
            heap.add(input)
            var index = heap.size - 1
            while (index > 1) {
                if (heap[index] < heap[index / 2]) {
                    heap[index] = heap[index / 2].also { heap[index / 2] = heap[index] }
                    index /= 2
                } else {
                    break
                }
            }
        }
//        println("$input   ${heap.joinToString(" ")}")
    }
    println(sb)
}

/*
16
0
3
1
0
7
8
0
4
9
5
0
32
2
0
0
0

답
0
1
3
4
2
5
7
 */