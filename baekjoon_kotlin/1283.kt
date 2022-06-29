/*

1283번 - 단축키 지정
https://www.acmicpc.net/problem/1283

flag를 설정해서 각 단어의 첫번째를 확인하고 단축키를 설정할 수 있는지에 따라 바꿨다.

Char.idx는 extension property(확장 프로퍼티)이고 getter를 구현했다.
data class 등에 사용하면 setter도 사용할 수 있다.
참고 링크:
https://medium.com/til-kotlin-ko/kotlin%EC%9D%98-extension%EC%9D%80-%EC%96%B4%EB%96%BB%EA%B2%8C-%EB%8F%99%EC%9E%91%ED%95%98%EB%8A%94%EA%B0%80-part-2-fb52bb20bc9e

repeat, foreach 등에서 return@repeat 을 하면 for에서 continue처럼 된다.
lambda 함수를 여러번 실행하는 구조이고 그 함수만 종료해주는 역할인 것 같다.
참고 링크:
https://iosroid.tistory.com/60

*/

package baekjoon_kotlin

private val Char.idx get() = lowercaseChar() - 'a'
fun main() = System.`in`.bufferedReader().run {
    val shortcut = BooleanArray(26)

    repeat(readLine().toInt()) {
        val sb = StringBuilder()
        val option = readLine()
        val split = option.split(" ")

        for ((i, str) in split.withIndex())
            if (!shortcut[str[0].idx]) {
                shortcut[str[0].idx] = true
                for ((j, s) in split.withIndex())
                    sb.append(if (j == i) "[${s[0]}]" + s.slice(1 until s.length) else s).append(" ")
                println(sb)
                return@repeat
            }

        var isFind = false
        for (c in option)
            sb.append(
                if (c != ' ' && !isFind && !shortcut[c.idx]) {
                    isFind = true
                    shortcut[c.idx] = true
                    "[$c]"
                } else c
            )

        println(sb)
    }
}

/*
12
Aab
Z bcd
a hw rf
h aH
BB hRf
haa aje
AHHAB Bz
ah zb a a k
ABB III
ajjeEt hhq
a j h h e o
apP po

*/