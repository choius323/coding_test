/*

2563번 - 색종이
https://www.acmicpc.net/problem/2563

흰색 도화지를 100*100 배열로 선언하고 검은색 도화지의 영역을 모두 돌며 true로 바꾼다.
모두 바꾸면 ture인 영역의 개수를 출력한다.
검은색 도화지가 있는 영역을 모두 확인해도 최대 10*10*100=10000이고 흰색 도화지의 true인 영역을 모두 확인해도 100*100이기 때문에 시간 복잡도가 작아서 오래 걸리지 않는다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val paper = Array(100) { BooleanArray(100) }
    repeat(r()) {
        val left = r()
        val bottom = r()
        for (x in left until left + 10) for (y in bottom until bottom + 10)
            paper[y][x] = true
    }
    print(paper.sumOf { p -> p.count { it } })
}

/*

*/