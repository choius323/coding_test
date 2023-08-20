package baekjoon_kotlin._17000/*

17218번 - 비밀번호 만들기
https://www.acmicpc.net/problem/17218
분류 : 다이나믹 프로그래밍, 문자열

DP를 활용한 LCS(Longest Common Substring) 알고리즘을 활용하는 문제이다.
현재 비교하려는 문자가 같으면 dp[a][b] = dp[a-1][b-1] + 1을 했고, 다르면 dp[a][b] = max(dp[a-1], dp[b-1])을 해서 가장 긴 문자열을 찾았다.
그 후 dp 마지막 부터 문자가 같으면 출력 후 대각선 이동, 다르면 더 큰 쪽으로 이동하며 어떤 문자열이 만들어졌는지 찾았다.

*/

fun main() {
    val str1 = " " + readln()
    val str2 = " " + readln()
    val dp = Array(str2.length) { IntArray(str1.length) }
    for (i2 in 1..str2.lastIndex) for (i1 in 1..str1.lastIndex) {
        dp[i2][i1] = maxOf(dp[i2 - 1][i1], dp[i2][i1 - 1], dp[i2 - 1][i1 - 1] + if (str1[i1] == str2[i2]) 1 else 0)
    }
    var answer = ""
    var i1 = str1.lastIndex
    var i2 = str2.lastIndex
    while (answer.length < dp.last().last()) {
        when {
            str1[i1] == str2[i2] -> {
                answer = str1[i1] + answer
                i1--
                i2--
            }

            dp[i2 - 1][i1] > dp[i2][i1 - 1] -> i2--
            else -> i1--
        }
    }
    print(answer)
}

/*fun main() {
    val strSet = mutableSetOf<String>()
    fun permutation(str: String, startIndex: Int, newStr: String, lambda: (String) -> Unit) {
        for (index in startIndex..str.lastIndex) {
            val s = newStr + str[index]
            lambda(s)
            permutation(str, index + 1, s, lambda)
        }
    }
    permutation(readln(), 0, "") {
        strSet.add(it)
    }
    var answer = ""
    permutation(readln(), 0, "") {
        if (it in strSet && answer.length < it.length) {
            answer = it
        }
    }
    print(answer)
}*/

/*
AUTABBEHNSA
BCUAMEFKAJNA

UAENA
*/