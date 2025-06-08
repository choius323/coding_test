package baekjoon_kotlin._21000

/*

21599번 - 아이템 배치하기
https://www.acmicpc.net/problem/21599
분류 : 그리디 알고리즘, 정렬

아이템의 순서를 바꿀 수 있고 한 아이템은 한 번만 강화할 수 있다.
따라서, 강화력을 내림차순으로 정렬하면 가장 적은 아이템에 영향을 끼칠 수 있다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val array = Array(n) { r() }.sortedArrayDescending()
    var remain = 0
    var answer = 0
    for (num in array) {
        if(num > remain) {
            remain = num
        }
        if(remain > 0) {
            answer += 1
        }

        remain -= 1
    }
    print(answer)
}

/*


*/