/*

1296번 - 팀 이름 정하기
https://www.acmicpc.net/problem/1296

각 원소별로 L, O, V, E와 나머지가 나온 개수를 저장하는 배열을 만든다.
그리고 when을 사용해서 인덱스를 가져오는 함수와 그 값의 인덱스를 서로 더해주는 함수를 작성했다.
입력 받을 때마다 적상한 함수를 사용해 값을 비교하고 최대값일 때의 이름을 출력하면 된다.

when을 사용하는 것보다 더 좋은 방법은 재귀함수를 사용해서 탐색하는 것이다.
관련 문제 : https://www.acmicpc.net/problem/15650

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): String {
        nextToken()
        return sval
    }

    fun getIndex(c: Char) = when (c) {
        'L' -> 0
        'O' -> 1
        'V' -> 2
        'E' -> 3
        else -> 4
    }

    fun IntArray.plus(c: Char, d: Char) = get(getIndex(c)) + get(getIndex(d))

    val count = IntArray(5)
    var name: String? = null
    i().forEach { count[getIndex(it)]++ }
    var ans = 0
    nextToken()
    repeat(nval.toInt()) {
        val c = count.clone()
        i().forEach { c[getIndex(it)]++ }
        val a = c.run {
            plus('L', 'O') * plus('L', 'V') * plus('L', 'E') *
                    plus('O', 'V') * plus('O', 'E') * plus('V', 'E')
        } % 100
        if (ans < a || (ans == a && (name ?: (sval + "z")) > sval)) {
            ans = a
            name = sval
        }
    }
    print(name)
}

/*

*/