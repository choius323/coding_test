/*

25185번 - 카드 뽑기
https://www.acmicpc.net/problem/25185

노가다를 조금 해서 풀었다.
첫 번째와 두 번째의 조건에 겹치는 부분이 있어서 같은 함수를 사용했다.

더 좋은 방법이 많을 것으로 생각된다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Card(val num: Int, val alp: Char)

    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    fun s(): String {
        nextToken()
        return sval
    }

    var str = Array(0) { Card(0, 'a') }
    fun same(a: Int, b: Int, c: Int) = arrayOf(str[a], str[b], str[c]).sortedBy { it.num }.let {
        it[0].alp == it[1].alp && it[1].alp == it[2].alp
                && ((it[0].num + 1 == it[1].num && it[1].num + 1 == it[2].num)
                || (it[0].num == it[1].num && it[1].num == it[2].num))
    }


    fun pair(a: Int, b: Int) = (str[a].alp == str[b].alp && str[a].num == str[b].num)


    val sb = StringBuilder()
    repeat(i()) {
        str = Array(4) { Card(i(), s()[0]) }
        sb.appendLine(
            if (same(0, 1, 2) || same(0, 1, 3) || same(0, 2, 3) || same(1, 2, 3)) ":)"
            else if ((pair(0, 1) && pair(2, 3)) || (pair(0, 2) && pair(1, 3)) || (pair(0, 3) && pair(1, 2))) ":)"
            else ":("
        )
    }
    print(sb)
}

/*

*/