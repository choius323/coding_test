/*

7662번 - 이중 우선순위 큐
https://www.acmicpc.net/problem/7662

처음엔 ArrayList로 했다가 시간 초과가 발생했고, ArrayDeque로 하니 꽤 오래 걸렸지만 시간 안에 됐는지 통과했다.
역시 탐색 부분이 오래 걸리는 것으로 보인다.

2번째 방법은 TreeMap을 이용하는 것이다.
TreeMap은 키값을 기준으로 오름차순 정렬 된 SortedMap 인터페이스를 구현한 클래스이다.
Map의 한 종류이기 때문에 삽입이 매우 빠르고 사용도 간편하다.

또 다른 방법은 우선순위 큐를 사용하는 것이다.
최대 힙, 최소 힙 2개로 우선순위 큐를 2개 사용해서 최대, 최소를 찾고 Map에 삭제한 값을 저장하며 체크하는 방법이 있다.
우선순위 큐 1개를 사용하면 최대 힙의 경우 최소값은 max함수를 사용해 제거하는 방식을 사용하면 된다.

*/

package baekjoon_kotlin._7000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val s = { r();sval }
    val sb = StringBuilder()
    repeat(r()) {
        val arr = java.util.TreeMap<Int, Int>()
        repeat(r()) {
            val c = s()
            val n = r()
            if (c[0] == 'I') {
                arr += n to (arr[n] ?: 0) + 1
            } else if (arr.size > 0) {
                val entry = if (n == 1) arr.pollLastEntry() else arr.pollFirstEntry()
                if (entry.value > 1) {
                    arr += entry.key to entry.value - 1
                }
            }
        }
        sb.appendLine(if (arr.isEmpty()) "EMPTY" else "${arr.lastKey()} ${arr.firstKey()}")
    }
    print(sb)
}

//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val arr = ArrayDeque<Int>()
//    repeat(br.readLine().toInt()) {
//        repeat(br.readLine().toInt()) {
//            val (c, n) = br.readLine().split(" ")
//            if (c == "I") {
//                val i = arr.binarySearch(n.toInt())
//                arr.add(if (i < 0) -i - 1 else i, n.toInt())
//            } else if (arr.isNotEmpty()) {
//                if (n == "1") {
//                    arr.removeLast()
//                } else {
//                    arr.removeFirst()
//                }
//            }
//        }
//        println(if (arr.isEmpty()) "EMPTY" else "${arr.last()} ${arr[0]}")
//        arr.clear()
//    }
//}

/*
3
7
I 16
I -5643
D -1
D 1
D 1
I 123
D -1
9
I -45
I 653
D 1
I -642
I 45
I 97
D 1
D -1
I 333
3
I 0
I 0
D 0

EMPTY
333 -45

2
6
I 16
I -5643
D -1
D 1
D 1
I 123
2
I -45
I -45

123 123
-45 -45
 */