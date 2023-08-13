package baekjoon_kotlin._11000

/*

11866번 - 요세푸스 문제 0
https://www.acmicpc.net/problem/11866
분류 : 구현자료, 구조, 큐

처음 시작은 인덱스가 0부터 시작하므로 k-1번째를 제거한다.
그 뒤에는 삭제한 인덱스의 자리에 다음 사람이 위치하고 있으므로 현재 자리가 1번째 사람이 된다.
따라서 현재 위치에서 k-1만큼 이동하면 제거할 사람의 위치이다.

*/

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val people = MutableList(n) { it + 1 }
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