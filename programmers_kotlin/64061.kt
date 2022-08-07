/*

64061번 - 크레인 인형뽑기 게임
https://school.programmers.co.kr/learn/courses/30/lessons/64061

편의를 위해 입력받은 보드의 x와 y를 바꾸고 안쪽 배열을 스택으로 바꿨다.
그리고 비어있지 않은 곳을 뽑을 때 Stack으로 만든 pick에 push를 하고 직전 값과 같을 때 answer에 2를 더한다.

*/

import java.util.*

private class Solution64061 {
    fun solution(boardArr: Array<IntArray>, moves: IntArray): Int {
        val pick = Stack<Int>()
        val board = List(boardArr[0].size) { Stack<Int>() }
        for (x in board.indices) {
            for (y in boardArr[0].lastIndex downTo 0) {
                if (boardArr[y][x] != 0) board[x].push(boardArr[y][x])
                else break
            }
        }
        var answer = 0
        moves.forEach {
            if (board[it - 1].isEmpty()) return@forEach
            pick.push(board[it - 1].pop())
            if (pick.size != 1 && pick.last() == pick[pick.lastIndex - 1]) {
                pick.pop()
                pick.pop()
                answer += 2
            }
        }
        return answer
    }
}

/*

*/