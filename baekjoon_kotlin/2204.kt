/*

2204번 - 도비의 난독증 테스트
https://www.acmicpc.net/problem/2204

리스트의 모든 문자를 확인하며 가장 작은 인덱스를 확인하고 그 인덱스의 값을 출력한다.
문자를 비교할 때는 lowercase나 uppercase를 사용해 대소문자를 통일하고 비교해야 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }
    while (true) {
        val n = i()
        if (n == 0) break
        val list = List(n) { i();sval }
        var i = 0
        var min = list[0].lowercase()
        for (idx in list.indices)
            if (min > list[idx].lowercase()) {
                i = idx
                min = list[idx].lowercase()
            }
        println(list[i])
    }
}

/*

*/