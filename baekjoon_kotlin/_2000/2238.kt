package baekjoon_kotlin._2000/*

2238번 - 경매
https://www.acmicpc.net/problem/2238

가격마다 모든 경매 인원을 저장하고 전체 가격을 탐색하며 가장 적은 인원이 있는 곳을 찾는다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val i = { nextToken(); nval.toInt() }
    val s = { nextToken(); sval }

    val u = i()
    val n = i()
    val list = List(u + 1) { ArrayList<String>() }

    repeat(n) {
        val name = s()
        list[i()].add(name)
    }

    var minPeople = n
    var minPrice = u
    for (price in 1 until u) {
        if (list[price].size in 1 until minPeople) {
            minPeople = list[price].size
            minPrice = price
        }
    }
    print("${list[minPrice][0]} $minPrice")
}

/*
10 5
Lew 10
CD 5
Fe 5
CD 7
LE 7
*/