/*

1987번 - 알파벳
https://www.acmicpc.net/problem/1987
분류 : 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 백트래킹

BFS로 탐색하면 경우의 수가 많아서 큐에 너무 많은 경로가 들어가서 메모리 초과가 발생할 수 있다.
하지만 DFS는 깊이가 알파벳 개수로 제한되어 있고, 한 번에 스택에 모든 경로가 생기지 않기 때문에 메모리 초과가 발생하지 않는다.
탐색했던 알파벳을 확인할 때는 visited를 Int로 선언해서 비트 연산을 통해 확인했다.

*/

fun main() = System.`in`.bufferedReader().run {
    fun Char.toNum() = this - 'A'
    val (r, c) = readLine().split(" ").map(String::toInt)
    val board = Array(r) { readLine() }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    var answer = 0
    fun dfs(x: Int, y: Int, visited: Int, count: Int) {
        answer = maxOf(answer, count)
        for (d in 0..3) {
            val nx = x + dx[d]
            val ny = y + dy[d]
            if (nx in 0 until c && ny in 0 until r) {
                val nextNum = 1 shl board[ny][nx].toNum()
                if (visited and nextNum == 0) {
                    dfs(nx, ny, visited or nextNum, count + 1)
                }
            }
        }
    }
    dfs(0, 0, 1 shl board[0][0].toNum(), 1)
    print(answer)
}

/*
20 20
ABCDEFGHIJKLMNOPQRST
BCDEFGHIJKLMNOPQRSTU
CDEFGHIJKLMNOPQRSTUV
DEFGHIJKLMNOPQRSTUVW
EFGHIJKLMNOPQRSTUVWX
FGHIJKLMNOPQRSTUVWXY
GHIJKLMNOPQRSTUVWXYZ
HIJKLMNOPQRSTUVWXYZA
IJKLMNOPQRSTUVWXYZAB
JKLMNOPQRSTUVWXYZABC
KLMNOPQRSTUVWXYZABCD
LMNOPQRSTUVWXYZABCDE
MNOPQRSTUVWXYZABCDEF
NOPQRSTUVWXYZABCDEFG
OPQRSTUVWXYZABCDEFGH
PQRSTUVWXYZABCDEFGHI
QRSTUVWXYZABCDEFGHIJ
RSTUVWXYZABCDEFGHIJK
STUVWXYZABCDEFGHIJKL
TUVWXYZABCDEFGHIJKLM

26
*/