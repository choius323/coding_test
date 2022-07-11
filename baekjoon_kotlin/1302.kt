/*

1302번 - 베스트셀러
https://www.acmicpc.net/problem/1302

책의 이름을 key, 개수를 value로 갖는 해시맵을 만들고 더 많거나 이름의 값이 더 작은 책으로 ans를 갱신하면 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): String {
        nextToken()
        return sval
    }

    val book = HashMap<String, Int>()
    var ans = ""
    nextToken()
    repeat(nval.toInt()) {
        book += i() to book.getOrDefault(sval, 0) + 1
        if (book.getOrDefault(ans, 0) < book[sval]!!) ans = sval
        else if (book.getOrDefault(ans, 0) == book[sval]!! && ans > sval) ans = sval
    }
    print(ans)
}

/*
2
a
b
*/