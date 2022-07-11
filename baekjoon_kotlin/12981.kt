/*

12981번 - 공 포장하기
https://www.acmicpc.net/problem/12981

각 색깔별로 3개씩 묶은 뒤 남은 공으로 만드는 박스의 개수를 더하면 된다.
남은 공으로 나오는 경우의 수는 9가지이고 (0,0,2)개일 때를 제외하면 가장 많이 남은 공과 박스의 개수가 같다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    var a = 0
    val b = IntArray(3) {
        nextToken()
        a += nval.toInt() / 3
        nval.toInt() % 3
    }.sorted()
    print(a + if (b[2] - b[1] == 2) 1 else b[2])
}

/*

*/