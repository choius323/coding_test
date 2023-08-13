/*

1181번 - 단어 정렬
https://www.acmicpc.net/problem/1181

set으로 중복을 지우고 사전, 길이 순으로 정렬한 뒤 출력하면 된다.
이분 탐색같은 것들을 사용하면 더 빠르다.
마지막의 forEach{println(it)} 대신 forEach{::println}을 사용해도 된다.

원래 파이썬으로 풀었던 문제지만 숏코딩이 해보고 싶어서 다시 해봤다.

*/

package baekjoon_kotlin._1000

fun main() = System.`in`.bufferedReader().run {
    Array(readLine().toInt()) { readLine() }.run { toSortedSet().sortedBy { it.length }.forEach { print("$it\n") } }
}

//fun main()=List(readLine()!!.toInt()){readLine()!!}.toSortedSet().sortedBy{it.length}.forEach{println(it)}

/*

*/