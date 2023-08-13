/*

4158번 - CD
https://www.acmicpc.net/problem/4158

HashSet, PriorityQueue, 투 포인터 방식을 사용해서 다르게 구현해봤다.
확실히 기본 배열만을 사용한 단순한 구조인 투 포인터 방식이 더 좋은 결과가 나왔다.

*/

package baekjoon_kotlin._4000

// HashSet 사용. 메모리는 많이 사용하지만 시간이 빠르고 코드 작성이 쉬움.
//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    fun i(): Int {
//        nextToken()
//        return nval.toInt()
//    }
//
//    val sb = StringBuilder()
//    while (true) {
//        val n = i()
//        val m = i()
//        if (n == 0 && m == 0) break
//        val cd = HashSet<Int>()
//        var count = 0
//        repeat(n) { cd.add(i()) }
//        repeat(m) { if (i() in cd) count += 1 }
//        sb.appendLine(count)
//    }
//    print(sb)
//}

// PriorityQueue(우선순위 큐) 사용. 메모리는 덜 사용하지만 느림.
//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    fun i(): Int {
//        nextToken()
//        return nval.toInt()
//    }
//
//    val sb = StringBuilder()
//    while (true) {
//        val n = i()
//        val m = i()
//        if (n == 0 && m == 0) break
//        val cd = java.util.PriorityQueue<Int>()
//        var count = 0
//        repeat(n) { cd.add(i()) }
//        repeat(m) {
//            val i = i()
//            while (cd.isNotEmpty() && cd.peek() <= i) {
//                if (cd.peek() == i)
//                    count += 1
//                cd.poll()
//            }
//        }
//        sb.appendLine(count)
//    }
//    print(sb)
//}

// 투 포인터 알고리즘. 속도도 빠르고, 메모리 사용도 적다. 어려우면 코드가 꼬이기 쉽다.
fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val sb = StringBuilder()
    while (true) {
        val n = i()
        val m = i()
        if (n == 0 && m == 0) break
        val ncd = IntArray(n) { i() }
        val mcd = IntArray(m) { i() }
        var np = 0
        var mp = 0
        var count = 0

        while (np < n && mp < m) {
            when (ncd[np].compareTo(mcd[mp])) {
                -1 -> np++
                1 -> mp++
                0 -> {
                    np++; mp++; count++
                }
            }
        }
        sb.appendLine(count)
    }
    print(sb)
}
/*
3 3
1
2
3
1
2
4
0 2
1
2
2 0
1
2
4 4
1 3 4 6
2 3 4 5
0 0

*/