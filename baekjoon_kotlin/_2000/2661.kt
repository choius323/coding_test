package baekjoon_kotlin._2000

/*

2661번 - 좋은수열
https://www.acmicpc.net/problem/2661
분류 : 백트래킹

문자열에 숫자를 추가하며 새로운 문자열을 포함한 수열이 나쁜 수열을 만드는지 확인한다.
숫자는 1,2,3 순서로 추가하며 가장 작은 숫자를 먼저 찾을 수 있게 하고 길이 n의 문자열을 찾으면 답을 출력한다.
수열을 확인할 때는 마지막 숫자부터 1 ~ length/2개씩 수열의 길이를 확인한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()

    fun check(str: String): Boolean {
        val len = str.length
        for (i in 0 until len / 2) {
            var right = len - 1
            var left = right - 1 - i
            var isSame = true
            while (right >= len - i - 1) {
                if (str[left] != str[right]) {
                    isSame = false
                    break
                }
                left--
                right--
            }
            if (isSame) return false
        }
        return true
    }

    fun permutation(str: String): String {
        if (check(str).not()) return ""
        else if (str.length == n) return str
        for (i in 1..3) {
            val answer = permutation(str + i)
            if (answer.isNotEmpty()) return answer
        }
        return ""
    }

    println(permutation(""))
}

/*

*/