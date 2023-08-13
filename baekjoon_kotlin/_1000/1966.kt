/*

1966번 - 프린터 큐
https://www.acmicpc.net/problem/1966

중요도를 PriorityQueue에 내림차순으로 넣고, 문서를 ArrayDeque에 저장했다.

그 다음은 중요도가 1~10밖에 없기 때문에 IntArray에 개수를 저장해 두고 max값을 바꾸는 방식으로 했다.
메모리 소모도 적어지고 속도도 빨라졌다.

*/

package baekjoon_kotlin._1000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken();return nval.toInt()
    }

    val sb = StringBuilder()
    repeat(i()) {
        val n = i()
        var m = i()
        var c = 1
        val dq = ArrayDeque<Int>()
        val im = IntArray(10)
        repeat(n) { dq.add(i()); im[nval.toInt()]++ }
        var max = im.indexOfLast { it != 0 }

        while (true) {
            val doc = dq.removeFirst()
            if (doc == max) {
                if (m == 0) break
                c += 1
                im[max] -= 1
                if (im[max] == 0) max = im.indexOfLast { it != 0 }
            } else dq.add(doc)
            m -= 1
            if (m < 0) m = dq.size - 1
        }
        sb.appendLine(c)
    }
    print(sb)
}

//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    fun i(): Int {
//        nextToken()
//        return nval.toInt()
//    }
//
//    val sb = StringBuilder()
//    repeat(i()) {
//        val n = i()
//        var m = i()
//        val pq = java.util.PriorityQueue<Int> { o1, o2 -> o2 - o1 } // 중요도를 내림차순으로 정렬
//        val deque = ArrayDeque<Int>()
//        repeat(n) { deque.add(i()); pq.add(nval.toInt()) }
//        while (true) {
//            val imp = deque.removeFirst()
//            if (m == 0 && pq.peek() == imp) break
//            if (pq.peek() == imp) pq.poll()
//            else {
//                deque.add(imp)
//                if (m == 0) m = deque.size
//            }
//            m -= 1
//        }
//        sb.appendLine(n - deque.size)
//    }
//    print(sb)
//}

/*

*/