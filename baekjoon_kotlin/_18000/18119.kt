package baekjoon_kotlin._18000

/*

18119번 - 단어 암기
https://www.acmicpc.net/problem/18119
분류 : 브루트포스 알고리즘, 비트마스킹

각 문자열의 길이와 문자열에 있는 문자 중 알고있는 문자의 개수를 저장하는 Word 클래스를 만든다.
그 후에 문자열이 포함하는 문자마다 Word를 리스트에 추가한다.
Word에 문자열 길이를 저장 할 때는 중복되는 문자와 모음을 제외하고 저장한다.
그 후에 문자를 기억하거나 잊을 때 해당 문자를 갖고 있는 Word 객체의 알고 있는 문자 개수를 바꿔준다.
문자열의 길이가 알고 있는 문자 개수와 같으면 알고 있는 단어의 개수에 1을 더해준다.
모든 문자를 알고 있다가 1개라도 잊어버리면 알고 있는 단어의 개수에서 1을 빼준다. 

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Word(val length: Int, var count: Int = length)

    val i = { nextToken();nval.toInt() }
    val s = { i();sval }
    val n = i()
    val m = i()
    val vowels = "aeiou".toSet()
    val words = Array('z' - 'a' + 1) { mutableListOf<Word>() }
    repeat(n) { _ ->
        val str = s().toSet().filter { it !in vowels }.joinToString("")
        val word = Word(str.length)
        str.forEach { words[it - 'a'].add(word) }
    }
    var knownWords = n
    val sb = StringBuilder()
    repeat(m) { _ ->
        val o = i()
        val charIdx = s()[0] - 'a'
        if (o == 2) {
            words[charIdx].forEach { word ->
                word.count++
                if (word.count == word.length) {
                    knownWords++
                }
            }
        } else {
            words[charIdx].forEach { word ->
                word.count--
                if (word.count + 1 == word.length) {
                    knownWords--
                }
            }
        }
        sb.appendLine(knownWords)
    }
    print(sb)
}

/*

*/