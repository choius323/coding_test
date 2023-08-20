/*

16953번 - A → B
https://www.acmicpc.net/problem/16953

처음에는 BFS를 활용해서 풀었고, visited는 b가 최대 10^9이므로 배열로 만들기엔 너무 커서 HashMap으로 만들었다.

그 다음에는 탑다운 방식으로 풀이를 했다.
이 문제는 바텀업으로 하면 n*2와 n*10+1 2가지 경우가 생기지만 탑다운으로 하면 앞의 2가지 경우가 동시에 존재할 수 없다.
따라서 visited같은 중복을 확인하는 작업이 따로 필요하지 않고, b의 여러 경우를 생각할 필요가 없다.
추가로 10을 곱하며 발생할 수 있는 오버플로우를 고려하지 않아도 돼서 Int로 작성할 수 있다.

*/

package baekjoon_kotlin._16000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val a = i()
    var b = i()
    var count = 1
    while (b > a) {
        count++
        b /= if (b % 10 == 1) 10
        else if (b % 2 == 0) 2
        else break
    }
    print(if (b == a) count else -1)
}

//fun main() {
//    var (a, b) = readLine()!!.split(" ").map { it.toInt() }
//    var c = 1
//    while (b > a) {
//        c++
//        b /= if (b % 10 == 1) 10 else if (b % 2 == 0) 2 else break
//    }
//    print(if (b == a) c else -1)
//}

//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    fun i(): Long {
//        nextToken()
//        return nval.toLong()
//    }
//
//    val a = i()
//    val b = i()
//    val queue = ArrayDeque<Long>()
//    queue.add(a)
//    val visited = hashMapOf(a to 0)
//    var count = 0
//
//    fun check(num: Long) {
//        if (num in 1..b && num !in visited) {
//            queue.add(num)
//            visited[num] = 0
//        }
//    }
//
//    while (queue.isNotEmpty()) {
//        count += 1
//        repeat(queue.size) {
//            val num = queue.removeFirst()
//            if (num == b) {
//                print(count)
//                return@run
//            }
//            check(num * 2)
//            check(num * 10 + 1)
//        }
//    }
//    print(-1)
//}
/*

*/