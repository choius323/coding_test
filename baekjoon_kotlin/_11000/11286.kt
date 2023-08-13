/*

11286번 - 절댓값 힙
https://www.acmicpc.net/problem/11286

처음엔 TreeMap을 이용해서 키는 절댓값, 값은 원래 숫자를 넣고 풀었다.
이렇게 풀면 Map과 여러개의 ArrayList가 생겨서 코드도 복잡해 지고 메모리도 많이 소모하게 된다.

그 다음에는 우선순위 큐를 사용해서 풀었다.
우선순위 큐는 Comparator를 사용해서 우선순위를 조정할 수 있는데, 조건을 잘 바꾸면 문제에서 원하는대로 출력이 가능하다.

*/

package baekjoon_kotlin._11000

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val que = PriorityQueue<Int> { a, b ->
        if (abs(a) == abs(b))
            a - b
        else
            abs(a) - abs(b)
    }
    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        if (n == 0) {
            if (que.isEmpty())
                sb.append("0\n")
            else
                sb.appendLine(que.remove())
        } else {
            que.add(n)
        }
    }
    print(sb)
}

//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.util.*
//import kotlin.math.abs
//
//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val sb = StringBuilder()
//    val heap = TreeMap<Int, ArrayList<Int>>()
//    repeat(br.readLine().toInt()) {
//        val n = br.readLine().toInt()
//        if (n == 0) {
//            if (heap.isEmpty())
//                sb.append("0\n")
//            else if (heap[heap.firstKey()]!!.size == 1)
//                sb.appendLine(heap.pollFirstEntry().value.first())
//            else
//                sb.appendLine(heap[heap.firstKey()]!!.removeFirst())
//        } else {
//            if (abs(n) in heap.keys)
//                heap[abs(n)]!!.add(if (n < 0) 0 else heap[abs(n)]!!.size, n)
//            else
//                heap[abs(n)] = arrayListOf(n)
//        }
//    }
//    print(sb)
//}

/*
18
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0
0
0
0

-1
1
0
-1
-1
1
1
-2
2
0
 */