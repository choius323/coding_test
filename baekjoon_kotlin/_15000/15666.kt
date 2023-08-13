/*

15666번 - N과 M (12)
https://www.acmicpc.net/problem/15666

N과 M 시리즈 마지막이다.
재귀함수로 풀었고 str에 추가한 인덱스를 인자로 넘겨주고 그 인덱스부터 다시 추가해 주면 된다.
배열을 set으로 바꾸기만 해도 중복이 제거돼서 편하지만, set으로 바꾸지 않고 for문 안에서 마지막에 추가한 숫자와 같은지 확인해주는 방법이 실행 시간은 더 빠르다.

*/

package baekjoon_kotlin._15000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val m = i()
    val arr = List(n) { i() }.toSet().sorted()
    val sb = StringBuilder()

    fun re(str: String, count: Int, index: Int) {
        if (count == m) sb.appendLine(str)
        else {
            for (a in index until arr.size)
                re("$str${arr[a]} ", count + 1, a)
        }
    }
    re("", 0, 0)
    print(sb)
}

/*

*/