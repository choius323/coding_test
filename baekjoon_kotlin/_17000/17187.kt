package baekjoon_kotlin._17000

/*

17187번 - 줄서기
https://www.acmicpc.net/problem/17187
분류 : 구현, 자료 구조, 시뮬레이션, 스택

입장 줄은 FIFO, 대기 공간은 FILO이기 때문에 각각 큐와 스택의 방식을 사용했다.
단, 대기 공간에 있는 사람을 빠르게 확인하기 위해서 Hash 알고리즘이 적용된 LinkedHashSet을 사용했다.

입장 순서를 확인할 때는 대기 공간에 있는지, 입장 줄에 있는지 확인하고 각각의 상황에 맞게 분기 처리를 했다.
입장 순서인 사람이 대기 공간에 있을 때 마지막에 들어간 경우가 아니면 입장이 불가능하다.

*/

fun main() {
    data class Ticket(val alpha: Char, val num: Int)

    val line = ArrayDeque<Ticket>()
    repeat(readln().toInt()) {
        line += readln().split(" ").map { Ticket(it[0], it.substring(2).toInt()) }
    }
    val waits = LinkedHashSet<Ticket>()
    line.sortedWith(compareBy({ it.alpha }, { it.num })).forEach { target ->
        if (target in waits) {
            if (waits.last() != target) {
                return print("BAD")
            } else {
                waits.remove(target)
            }
        } else {
            while (true) {
                val first = line.removeFirstOrNull() ?: return print("BAD")
                if (first == target) break
                waits.add(first)
            }
        }
    }
    print("GOOD")
}