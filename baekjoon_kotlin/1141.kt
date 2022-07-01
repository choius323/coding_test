/*

1141번 - 접두사
https://www.acmicpc.net/problem/1141

A가 B의 접두사가 되려면 A의 길이가 B의 길이 이하여야 한다.
우선 입력받은 문자를 길이를 기준으로 정렬하고 각 문자 뒤의 문자들을 모두 확인하며 접두사가 되는지 확인한다.

sortWith는 Comparator 함수를, sortBy는 속성 함수를 파라미터로 받는다.
startWith, sortBy 등 함수를 잘 알아두자.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    nextToken()
    val n = nval.toInt()
    val words = Array(n) { nextToken();sval }.sortedBy { it.length }
    var count = 0
    loop@ for (i in 0 until n) {
        for (j in i + 1 until n)
            if (words[j].startsWith(words[i]))
                continue@loop
        count += 1
    }
    print(count)
}

/*
3
a
ab
ac

*/