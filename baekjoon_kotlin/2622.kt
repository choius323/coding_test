/*

2622번 - 삼각형만들기
https://www.acmicpc.net/problem/2622

leg1<leg2+leg3이고 leg1+leg2+leg3==n이다.
count를 추가할 때 중복이 발생하지 않게 하려면 n/3 <= leg1 < n/2, leg1/2 <= leg2 <= leg1 이 만족하면 된다.

추가로 O(n)을 만족하는 방법이 있다.
https://www.acmicpc.net/source/32472687
https://gumgood.tistory.com/162

*/

package baekjoon_kotlin

fun main() = System.`in`.bufferedReader().run {
    val n = readLine().toInt()
    var count = 0
    for (leg1 in n / 3..n / 2) { // n/2에서 버림이 발생해서 n/2를 포함. range에는 Int만 가능.
        for (leg2 in leg1 / 2..leg1) {
            val leg3 = n - leg1 - leg2
            if (leg1 < leg2 + leg3 && leg3 <= leg2 && leg1 > 0 && leg2 > 0 && leg3 > 0) count += 1
        }
    }
    print(count)
}

/*

*/