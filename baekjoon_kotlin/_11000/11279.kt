/*

11279번 - 최대 힙
https://www.acmicpc.net/problem/11279

최대 힙의 기본 기능을 만드는 문제이다.
ArrayList<Int>.swap()과 같은 함수를 만들면 호출할 때 사용한 배열은 this로 사용 가능하다.
ArrayList와 ArrayDeque의 성능 차이는 거의 없었다.
힙에서 삭제하고 다시 정렬 할 때 반드시 n*2와 n*2+1의 숫자를 비교하고 바꿔야 한다.

*/

package baekjoon_kotlin._11000

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val arr = ArrayList<Int>()
    arr.add(-1)
    repeat(br.readLine().toInt()) {
        val input = br.readLine().toInt()
        if (input == 0) {
            if (arr.size == 1) {
                sb.appendLine(0)
            } else {
                arr.swap(1, arr.lastIndex)
                sb.appendLine(arr.removeLast())
                var i = 1
                while (i * 2 <= arr.lastIndex) {
                    var biggerIndex: Int
                    if (i * 2 + 1 <= arr.lastIndex) {
                        biggerIndex = if (arr[i * 2] > arr[i * 2 + 1]) i * 2 else i * 2 + 1
                    } else {
                        biggerIndex = i * 2
                    }
                    if (arr[i] <= arr[biggerIndex]) {
                        arr.swap(i, biggerIndex)
                        i = biggerIndex
                    } else {
                        break
                    }
                }
            }
        } else {
            arr.add(input)
            var i = arr.lastIndex
            while (i > 1 && arr[i] > arr[i / 2]) {
                arr.swap(i, i / 2)
                i /= 2
            }
        }
    }
    print(sb)
}

private fun ArrayList<Int>.swap(a: Int, b: Int) {
    this[a] = this[b].also { this[b] = this[a] }
}

/*
13
0
1
2
0
0
3
2
1
0
0
0
0
0

0
2
1
3
2
1
0
0

17
0
1
2
3
0
4
5
5
0
5
5
0
0
0
0
0
0

 */