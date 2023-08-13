package baekjoon_kotlin._10000

/*

10994번 - 별 찍기 - 19
https://www.acmicpc.net/problem/10994

재귀함수를 사용해서 가장 바깥쪽 사각형 부터 안쪽으로 가며 별을 찍는다.
재귀함수는 길이가 1일 때 종료하고 x와 y좌표는 2씩 증가하고 길이는 4씩 감소한다.

4n-3 = (2n-1) + 2(n-1) <- 2(n-1):중심 부분 공백의 수
or 매번 양 옆으로 4칸이 증가함, 초기값은 1

*/

fun main() {
    fun draw(star: Array<CharArray>, x: Int, y: Int, n: Int) {//출력할 배열, 왼쪽 위의 x 및 y좌표, 가로세로 길이
        if (n == 1) {
            star[y][x] = '*'
            return
        }
        for (i in 0 until n) { //사각형 테두리에 별 찍기
            star[y][x + i] = '*'
            star[y + i][x] = '*'
            star[n + y - 1][n + y - 1 - i] = '*'
            star[n + y - 1 - i][n + y - 1] = '*'
        }
        draw(star, x + 2, y + 2, n - 4)
    }

    val n = readln().toInt()
    val star = Array(4 * n - 3) { CharArray(4 * n - 3) { ' ' } }
    draw(star, 0, 0, star.size)
    val sb = StringBuilder()
    star.forEach {
        it.forEach { c -> sb.append(c) }
        sb.appendLine()
    }
    print(sb)
//    println(star.joinToString("") { it.joinToString("") + "\n" })
}

/*

*/