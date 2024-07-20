package baekjoon_kotlin._11000

/*

11559번 - Puyo Puyo
https://www.acmicpc.net/problem/11559
분류 : 구현, 그래프 이론, 그래프 탐색, 시뮬레이션, 너비 우선 탐색

연쇄반응을 확인하기 위해 색상이 4개 이상 연결된 곳을 모두 찾고 동시에 터트린다.
그 후 위에 있는 뿌요를 아래로 내리는데 큐를 사용해서 빈칸을 저장한 뒤 하나씩 내렸다.

*/

private operator fun Array<BooleanArray>.get(pos: Pos) = this[pos.y][pos.x]
private operator fun Array<BooleanArray>.set(pos: Pos, bool: Boolean) {
    this[pos.y][pos.x] = bool
}

private operator fun Array<CharArray>.get(pos: Pos) = this[pos.y][pos.x]
private operator fun Array<CharArray>.set(pos: Pos, char: Char) {
    this[pos.y][pos.x] = char
}

private data class Pos(val x: Int, val y: Int)

fun main() {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val field = Array(12) { readln().toCharArray() }

    fun checkRange(pos: Pos) = pos.x in field[0].indices && pos.y in field.indices

    fun checkConnection(visited: Array<BooleanArray>, startPos: Pos): Boolean {
        var count = 0
        val queue = mutableListOf(startPos)
        var queueIdx = 0
        val type = field[startPos.y][startPos.x]
        visited[startPos] = true
        while (queueIdx in queue.indices) {
            val pos = queue[queueIdx++]
            for (d in 0..3) {
                val nPos = Pos(pos.x + dx[d], pos.y + dy[d])
                if (checkRange(nPos).not() || visited[nPos] || field[nPos] != type) continue
                count++
                visited[nPos] = true
                queue += nPos
            }
        }
        return if (queue.size >= 4) {
            for (pos in queue) {
                field[pos] = '.'
            }
            true
        } else {
            false
        }
    }

    fun fall() {
        for (x in field[0].indices) {
            val queue = ArrayDeque<Pos>()
            for (y in field.lastIndex downTo 0) {
                val pos = Pos(x, y)
                if (field[pos] == '.') {
                    queue += pos
                } else if (queue.isNotEmpty()) {
                    field[queue.removeFirst()] = field[pos]
                    field[pos] = '.'
                    queue += pos
                }
            }
        }
    }

    fun chain(count: Int): Int {
        val visited = Array(field.size) { BooleanArray(field[0].size) }
        var isFind = false
        for (x in field[0].indices) {
            for (y in field.indices) {
                if (field[y][x] != '.') {
                    isFind = checkConnection(visited, Pos(x, y)) || isFind
                }
            }
        }
        if (isFind) {
            fall()
            return chain(count + 1)
        } else {
            return count
        }
    }

    print(chain(0))
}

/*

*/