/*

1159번 - 농구 경기
https://www.acmicpc.net/problem/1159

알파벳 크기 만큼의 배열을 만들고 각각 글자가 나올 때마다 1씩 더해준다.
a를 첫번째 인덱스(0)으로 쓴다.

*/

fun main() {
    val n = IntArray(26)
    repeat(readln().toInt()) { n[readln()[0] - 'a'] += 1 }
    val s = StringBuilder()
    repeat(n.size) { if (n[it] > 4) s.append('a' + it) }
    print(s.ifEmpty { "PREDAJA" })
}

/*

*/