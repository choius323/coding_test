/*

1759번 - 암호 만들기
https://www.acmicpc.net/problem/1759

암호는 알파벳 순서로 정렬되어 있기 때문에 입력받은 문자를 정렬한 뒤에 dfs로 순차 탐색을 하며 단어 조합을 찾았다.
그 후에 자음과 모음의 개수를 확인하고 조건에 맞으면 출력을 했다.

*/

fun main() = System.`in`.bufferedReader().run {
    val (l, c) = readLine().split(" ").map { it.toInt() }
    val charArray = readLine().split(" ").map { it.first() }.sorted()
    val answer = StringBuilder()

    fun dfs(word: String, consonant: Int, vowel: Int, index: Int) {
        if (word.length == l) {
            if (consonant >= 2 && vowel >= 1) answer.appendLine(word)
            return
        }
        for (i in index until c) {
            val isVowel = when (charArray[i]) {
                'a', 'e', 'i', 'o', 'u' -> true
                else -> false
            }
            dfs(
                word + charArray[i],
                consonant + if (isVowel) 0 else 1,
                vowel + if (isVowel) 1 else 0,
                i + 1,
            )
        }
        return
    }

    dfs("", 0, 0, 0)
    print(answer)
}

/*

*/