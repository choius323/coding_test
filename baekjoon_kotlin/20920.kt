/*

20920번 - 영단어 암기는 괴로워
https://www.acmicpc.net/problem/20920
분류 : 자료 구조, 문자열, 정렬, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵

groupingBy로 key과 key가 나온 개수를 map으로 저장한다.
그 후에 문제의 조건에 맞게 정렬한다.
compareBy로 정렬 기준을 주면 순서대로 우선 순위를 부여할 수 있다.
use는 Closeable 객체를 사용할 때 마지막에 close를 호출해주는 함수이다.

*/

fun main() = System.`in`.bufferedReader().run {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    System.out.bufferedWriter().use { bw ->
        Array(n) { readLine() }.groupingBy { it }.eachCount().entries
            .sortedWith(compareBy({ -it.value }, { -it.key.length }, { it.key }))
            .forEach {
                if (it.key.length >= m) {
                    bw.write(it.key)
                    bw.newLine()
                }
            }
    }
}

/*

*/