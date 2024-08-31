package baekjoon_kotlin._30000

/*

30023번 - 전구 상태 바꾸기
https://www.acmicpc.net/problem/30023
분류 : 구현, 그리디 알고리즘

가장 앞에 있는 전구부터 차례로 탐색하며 한 색으로 모두 통일 되도록 전구의 상태를 변경한다.
RGB 각 색을 모두 확인하며 가장 적은 횟수를 찾는다.

*/

fun main() {
    val MAX = 10_000_000
    val n = readln().toInt()
    val bulbs = readln().toCharArray()
    val changeColor = mapOf('R' to 'G', 'G' to 'B', 'B' to 'R')
    val cancelColor = mapOf('G' to 'R', 'B' to 'G', 'R' to 'B')

    fun change(startIdx: Int, target: Char): Int {
        if (startIdx == n - 2) {
            return if (target == bulbs[startIdx] && target == bulbs[startIdx + 1]) {
                0
            } else {
                MAX
            }
        }
        var min = MAX
        if (target == bulbs[startIdx]) return change(startIdx + 1, target)

        for (changeIdx in startIdx..startIdx + 2) {
            bulbs[changeIdx] = changeColor[bulbs[changeIdx]] ?: error(' ')
        }
        min = minOf(min, change(startIdx, target) + 1)
        for (changeIdx in startIdx..startIdx + 2) {
            bulbs[changeIdx] = cancelColor[bulbs[changeIdx]] ?: error(' ')
        }
        return min
    }

    print(minOf(change(0, 'R'), change(0, 'G'), change(0, 'B')).takeIf { it != MAX } ?: -1)
}

/*
4
RGGB

3

RGGB
RBBR
RRRG
GGGG

RGGB
GBBB
GRRR
GGGG


5
BGRGB

3

*/