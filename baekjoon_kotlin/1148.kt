/*

1148번 - 단어 만들기
https://www.acmicpc.net/problem/1148
분류 : 구현, 문자열

사전의 문자열을 각 문자(A~Z)가 나오는 횟수로 변환한 배열로 각각 저장한다.
그 후 퍼즐판을 입력할 때 마다 결과를 계산해서 출력한다.
퍼즐판을 입력하면 사전에서 만들 수 있는 문자열을 찾고, 만들 수 있는 단어의 문자마다 개수를 더해준다.
그 후에 나온 개수가 가장 적은 문자와 가장 많이 나온 문자를 출력한다.

*/

fun main() = System.`in`.bufferedReader().run {
    val dict = mutableListOf<ByteArray>()
    while (true) {
        val input = readLine()
        if (input[0] == '-') break
        val counts = ByteArray('z' - 'a' + 1)
        for (c in input) counts[c - 'A']++
        dict += counts
    }
    while (true) {
        val str = readLine()
        if (str[0] == '#') break
        val charCounts = IntArray('z' - 'a' + 1)
        val answer = IntArray('z' - 'a' + 1) { -1 }
        for (c in str) {
            charCounts[c - 'A']++
            answer[c - 'A'] = 0
        }
        out@ for (word in dict) {
            for (i in word.indices) {
                if (charCounts[i] < word[i]) {
                    continue@out
                }
            }
            for (i in word.indices) {
                if (word[i] > 0) answer[i]++
            }
        }
        val min = answer.filter { it >= 0 }.min()
        val max = answer.max()
        val minChars = StringBuilder()
        val maxChars = StringBuilder()
        for (i in answer.indices) {
            if (answer[i] == min) minChars.append('A' + i)
            if (answer[i] == max) maxChars.append('A' + i)
        }
        println("$minChars $min $maxChars $max")
    }
}

/*

*/