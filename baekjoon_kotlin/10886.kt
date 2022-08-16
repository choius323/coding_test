/*

10886번 - 0 = not cute / 1 = cute
https://www.acmicpc.net/problem/10886

숫자를 모두 입력 받으며 0과 1의 개수를 세고 더 큰 숫자를 찾는다.
항상 홀수개 만큼 입력받기 때문에 같은 경우는 없다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    var c = 0
    var n = 0
    repeat(r()) { if (r() == 1) c++ else n++ }
    print("Junhee is${if (c > n) "" else " not"} cute!")
}

/*

*/