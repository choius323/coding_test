package baekjoon_kotlin._27000

/*

27740번 - 시프트 연산
https://www.acmicpc.net/problem/27740
분류 : 그리디 알고리즘, 브루트포스 알고리즘, 해 구성하기

한 방향으로만 옮기거나, i번째까지 왼쪽으로 옮긴 후 i+1번째를 오른쪽으로 옮기는 방법이 가장 적은 방법이다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val list = IntArray(n) { r() }
    val positions = mutableListOf<Int>()
    for ((idx, num) in list.withIndex()) {
        if (num == 1) positions += idx
    }
    var leftAnswer = Int.MAX_VALUE / 2
    var rightAnswer = Int.MAX_VALUE / 2

    fun check(left: Int, right: Int) {
        if (leftAnswer + rightAnswer > left + right) {
            leftAnswer = left
            rightAnswer = right
        }
    }

    check(positions.last() + 1, 0)
    check(0, n - positions.first())

    for (i in 0..positions.size - 2) {
        check(positions[i] + 1, positions[i] + 1 + n - positions[i + 1])
        check(n - positions[i + 1] + positions[i] + 1, n - positions[i + 1])
    }

    println(leftAnswer + rightAnswer)
    print(
        if (leftAnswer < rightAnswer) {
            "L".repeat(leftAnswer) + "R".repeat(rightAnswer)
        } else {
            "R".repeat(rightAnswer) + "L".repeat(leftAnswer)
        }
    )
}

/*
5
0 1 1 1 1

RRRR


5
0 1 0 1 1

RRRR


5
1 0 0 1 0

LLLL


5
0 1 1 0 0


7
0 1 0 0 0 0 1

RLLL


5
0 0 1 0 0

LLL

*/

/*

var left = -1
var right = -1
if (n % 2 == 1) {
    var dist = 0
    while (n / 2 - dist >= 0) {
        val ll = list[n / 2 - dist]
        val rr = list[n / 2 + dist]
        if (list[ll] == 1 && list[rr] == 1) {
            return print("L".repeat(n - dist))
        } else if (list[ll] == 1 && left == -1) {
            left = n / 2 - dist
        } else if (list[rr] == 1 && right == -1) {
            right = n / 2 - dist
        }
        dist++
    }
}
println("$left $right")
 */