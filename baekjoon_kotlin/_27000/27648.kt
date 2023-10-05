/*

27648번 - 증가 배열 만들기
https://www.acmicpc.net/problem/27648
분류 : 애드 혹, 해 구성하기

수열의 가장 긴 길이는 (1,1)->(N,M)일 때 N+M-1이다.
따라서 K가 N+M-1 이상일 때 배열을 만들 수 있다.
배열은 (i,j)+1 == (i+1,j) == (i,j+1)로 만들 때 가장 작은 수로도 배열을 만들 수 있다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val k = r()
    val sb = StringBuilder()
    if (k >= n + m - 1) {
        sb.appendLine("YES")
        for (y in 1..n) {
            for (x in 1..m) {
                sb.append("${x + y - 1} ")
            }
            sb.appendLine()
        }
    } else {
        sb.appendLine("NO")
    }
    print(sb)
}

/*

*/