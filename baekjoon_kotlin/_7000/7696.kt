/*

7696번 - 반복하지 않는 수
https://www.acmicpc.net/problem/7696

n이 최대 1000000이고 테스트를 여러번 하므로 미리 계산해서 저장해 놓는다.
그 후에 n을 입력받고 출력한다.
숫자를 문자열->배열->셋으로 바꾸면 중복을 체크할 수 있지만 메모리가 부족하기 때문에 사용할 수 없다.

*/

package baekjoon_kotlin._7000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val answer = IntArray(1000001)
    var i= 0
    var count=0
    var n: Int
    val bool = BooleanArray(10)
    val sb = StringBuilder()
    while (answer[1000000] == 0) {
        i++
        var temp = i
        bool.fill(false)
        while (true) {
            if (!bool[temp % 10]) {
                bool[temp % 10] = true
            } else break
            temp /= 10
            if (temp == 0) {
                count += 1
                answer[count] = i
                break
            }
        }
    }
    while (true) {
        n = i()
        if (n == 0) break
        sb.appendLine(answer[n])
    }
    print(sb)
}

/*

*/