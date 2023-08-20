package baekjoon_kotlin._18000/*

18513번 - 샘터
https://www.acmicpc.net/problem/18513

샘의 범위가 -1억~1억이기 때문에 배열에 저장하지 않고 맵에 저장해서 중복을 체크한다.
BFS를 활용하여 불행도를 최소한으로 더하게 하고 집을 지을 수 있을 때마다 큐와 맵에 저장한다.
맵의 키는 샘이나 집의 위치, 값은 불행도를 저장한다.
큐에 새로운 집을 저장할 때마다 불행도를 1씩 갱신하며 저장한다.
-1과 +1자리를 체크할 때 2번째 하는 pos+1은 pos-1에서 count가 증가할 수 있기 때문에 count를 다시 체크해야 한다.
샘의 위치는 -1억~1억이지만 집의 범위는 지정하지 않았기 때문에 따로 체크할 필요가 없다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val k = r()
    val house = hashMapOf<Int, Int>()
    val queue = ArrayDeque<Int>()
    var count = 0
    var answer = 0L
    repeat(n) {
        house += r() to 0
        queue += nval.toInt()
    }
    while (count < k) {
        val pos = queue.removeFirst()
        if (pos - 1 !in house) {
            queue += pos - 1
            house += pos - 1 to house[pos]!! + 1
            answer += house[pos - 1]!!
            count++
        }
        if (count < k && pos + 1 !in house) {
            queue += pos + 1
            house += pos + 1 to house[pos]!! + 1
            answer += house[pos + 1]!!
            count++
        }
    }
    print(answer)
}

/*
3 1
0 5 8

3 5
-100000000 0 100000000

2 5
0 1
*/