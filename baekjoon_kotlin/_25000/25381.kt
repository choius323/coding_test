package baekjoon_kotlin._25000

/*

25381번 - ABBC
https://www.acmicpc.net/problem/25381
분류 : 자료 구조, 그리디 알고리즘, 큐

순차적으로 문자열을 탐색했을 때 B 앞에 있는 A는 더 뒤에 있는 B를 모두 볼 수 있다.
하지만 B 뒤에 있는 C는 자기 앞의 B만 볼 수 있기 때문에 C가 먼저 B를 선택해야 한다.

*/

fun main() {
    var countA = 0
    var countB = 0
    var countAB = 0
    var countBC = 0
    for (c in readln()) {
        when (c) {
            'A' -> countA++
            'B' -> if (countA > 0) {
                countA--
                countAB++
            } else {
                countB++
            }

            'C' -> if (countB > 0) {
                countB--
                countBC++
            } else if (countAB > 0) {
                countAB--
                countA++
                countBC++
            }
        }
    }
    print(countAB + countBC)
}

/*

*/