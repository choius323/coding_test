package baekjoon_kotlin._6000

/*

6581번 - HTML
https://www.acmicpc.net/problem/6581
분류 : 문자열, 파싱

문자열을 한 글자씩 입력받으며 StringBuilder에 저장한다.
공백 문자일 경우 단어 입력을 마치고 line StringBuilder에 단어를 추가한다.
80자가 넘어가는 경우, br, hr을 입력받을 때를 따로 처리해 준다.

여러가지 실수를 해서 여러번 틀렸다.
1. 단어의 구성 요소를 알파벳과 쉼표, 점만 있다고 생각했는데, 다시 읽어보니 숫자와 문장 부호(괄호, 말 줄임표 등)를 포함하고 있었다.
2. 한 줄의 제한을 80자 미만으로 보았다.
3. 반복문이 끝난 뒤 word, line에 각각 남은 문자열을 출력해야 하는데, word만 출력했다.

 */

fun main() = System.`in`.bufferedReader().run {
    val hr = "-".repeat(80)
    val sb = StringBuilder()
    val line = StringBuilder()
    val word = StringBuilder()
    fun flushLine() {
        if (line.isNotEmpty()) {
            sb.appendLine(line.trim())
            line.clear()
        }
    }

    fun flushWord() {
        when {
            word.isEmpty() -> return
            word.toString() == "<br>" -> if (line.isEmpty()) sb.appendLine() else flushLine()

            word.toString() == "<hr>" -> {
                flushLine()
                line.append(hr)
                flushLine()
            }

            line.length + word.length > 80 -> {
                flushLine()
                line.append("$word ")
            }

            else -> {
                line.append("$word ")
            }
        }
        word.clear()
    }
    while (ready()) {
        val c = read().toChar()
        when {
            c.isWhitespace() -> {
                flushWord()
            }

            else -> word.append(c)
        }
    }
    flushWord()
    flushLine()
    print(sb.toString().trim())
}