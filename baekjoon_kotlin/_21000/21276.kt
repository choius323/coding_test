package baekjoon_kotlin._21000

/*

21276번 - 계보 복원가 호석
https://www.acmicpc.net/problem/21276
분류 : 자료 구조, 그래프 이론, 정렬, 트리, 해시를 사용한 집합과 맵, 위상 정렬

이름-배열의 인덱스를 Key-Value로 갖는 Map, 이름을 value로 갖는 배열을 선언한다.
그래프는 조상->자식 방향으로 인접 리스트를 저장한 뒤 위상 정렬을 수행하며 자신의 자식을 찾는다.
마지막에 위상 정렬을 처음 시작할 때 찾았던 조상을 출력하고, 각 이름 별 자식을 출력한다.

인접 리스트를 자식->조상으로 저장하고 위상 정렬을 수행하면 자식-조상이 직접 연결된 경우를 찾기 힘들다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val s = { r();sval }
    val n = r()
    val nameMap = mutableMapOf<String, Int>()
    val names = Array(n) { idx ->
        val str = s()
        nameMap += str to idx
        str
    }

    val children = Array(n) { mutableListOf<Int>() }
    val counts = IntArray(n)
    repeat(r()) {
        val child = nameMap[s()] ?: -1
        val parent = nameMap[s()] ?: -1
        children[parent] += child
        counts[child]++
    }

    val roots = mutableListOf<Int>()
    val deque = ArrayDeque<Int>()
    for (i in 0 until n) {
        if (counts[i] == 0) {
            roots += i
            deque += i
        }
    }

    while (deque.isNotEmpty()) {
        val parent = deque.removeFirst()
        val list = mutableListOf<Int>()
        for (child in children[parent]) {
            counts[child]--
            if (counts[child] == 0) {
                list += child
                deque += child
            }
        }
        children[parent] = list
    }

    fun List<Int>.indicesToSortedNames() = map { names[it] }.sorted().joinToString(" ")

    val sb = StringBuilder()
    sb.appendLine(roots.size).appendLine(roots.indicesToSortedNames())
    nameMap.toSortedMap().forEach { (name, idx) ->
        val list = children[idx]
        sb.append(name).append(' ').append(list.size).append(' ').appendLine(list.indicesToSortedNames())
    }
    print(sb)
}

/*

*/