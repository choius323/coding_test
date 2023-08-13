/*

1158번 - 요세푸스 문제
https://www.acmicpc.net/problem/1158

제거되는 사람은 (i+k)%남은인원수 이다.
제거된 사람의 자리와 배열의 인덱스를 잘 생각해야 한다.

*/

package baekjoon_kotlin._1000

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val people = ArrayList<Int>().also { it.addAll(1..n) }
    val sb = StringBuilder()
    var i = 0
    while (people.size > 1) {
        i = (i + k - 1) % people.size
        sb.append("${people.removeAt(i)}, ")
    }
    print("<$sb${people[0]}>")
}

/*

*/