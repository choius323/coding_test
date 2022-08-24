/*

25495번 - 에어팟
https://www.acmicpc.net/problem/25495

핸드폰을 입력받을 때 이번 연결의 사용량을 변경하고 현재 에어팟의 사용량을 갱신한다.
사용량이 100이 되면 배터리의 사용량을 0으로 변경하고 사용한 핸드폰의 정보를 초기화 한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    var battery = 0
    var use = 0
    var phone = -1
    repeat(r()) {
        val a = r()
        if (phone != a) {
            use = 2
            phone = a
        } else use *= 2
        battery += use
        if (battery >= 100) {
            phone = -1
            battery = 0
        }
    }
    print(battery)
}

/*
6
2 2 2 2 2 2
*/