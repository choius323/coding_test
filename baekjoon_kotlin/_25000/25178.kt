/*

25178번 - 두라무리 휴지
https://www.acmicpc.net/problem/25178

filter를 사용하면 쉽게 해결 된다.

*/

package baekjoon_kotlin._25000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    nextToken()
    val n = nval.toInt()
    nextToken()
    val str = sval.toCharArray()
    nextToken()
    val str2 = sval.toCharArray()
    val vowel = arrayOf('a', 'e', 'i', 'o', 'u')
    print(if (str[0] == str2[0] && str[n - 1] == str2[n - 1] && str.sorted() == str2.sorted() &&
        str.filter { it !in vowel } == str2.filter { it !in vowel }
    ) "YES" else "NO")
}

/*

*/