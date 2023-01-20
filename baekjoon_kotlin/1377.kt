/*

1377번 - 버블 소트
https://www.acmicpc.net/problem/1377

직접 버블 정렬을 구현하면 n*n의 시간 복잡도를 가지므로 시간 초과가 발생한다.
따라서 시간이 빠른 다른 정렬 방법을 사용해 정렬하고, 원래 인덱스와 정렬 후 인덱스를 비교하면 된다.

버블 정렬은 한 사이클이 돌 때 뒤로는 몇칸이든 이동할 수 있지만, 앞으로는 한 칸만 이동할 수 있다.
따라서 앞으로 이동한 칸 수의 최대값이 정렬을 마치는 데 걸리는 시간이다.
그리고 답인 처음으로 움직이지 않는 인덱스는 정렬을 마친 뒤에 나오는 인덱스이다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    var maxDist = 0
    List(r()) { r() to it }.sortedBy { it.first }.forEachIndexed { newIdx, (_, oldIdx) ->
        maxDist = maxOf(maxDist, oldIdx - newIdx)
    }
    print(++maxDist)
}

/*

*/