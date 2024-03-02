package baekjoon_kotlin._1000

/*

1711번 - 직각삼각형
https://www.acmicpc.net/problem/1711
분류 : 브루트포스 알고리즘, 기하학, 피타고라스 정리

점 중에 3개를 선택해서 직각삼각형을 만들 수 있는지 확인하면 된다.
피타고라스 정리를 사용해 확인하며 어떤 점이 직각을 만들지 모르기 때문에 점 3개에서도 3가지 경우를 모두 확인해야 한다.

미리 점 사이의 거리를 계산했을 때가 더 오래 걸렸다.

 */

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Pos(val x: Long, val y: Long) {
        fun dist2(other: Pos) = (x - other.x).let { it * it } + (y - other.y).let { it * it }
    }

    val r = { nextToken();nval.toLong() }
    val posList = List(r().toInt()) { Pos(r(), r()) }
    var count = 0

    fun check(pos1: Pos, pos2: Pos, pos3: Pos): Boolean =
        pos1.dist2(pos2) + pos2.dist2(pos3) == pos1.dist2(pos3)
                || pos2.dist2(pos3) + pos3.dist2(pos1) == pos1.dist2(pos2)
                || pos3.dist2(pos1) + pos1.dist2(pos2) == pos2.dist2(pos3)

    fun recur(indices: IntArray, nextIndices: Int) {
        if (nextIndices == 3) {
            if (check(posList[indices[0]], posList[indices[1]], posList[indices[2]])) {
                count++
            }
            return
        }
        for (num in (indices.getOrNull(nextIndices - 1)?.plus(1) ?: 0)..posList.lastIndex) {
            indices[nextIndices] = num
            recur(indices, nextIndices + 1)
        }
    }

    recur(IntArray(3), 0)
    print(count)
}