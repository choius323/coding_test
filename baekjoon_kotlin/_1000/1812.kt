package baekjoon_kotlin._1000/*

1812번 - 사탕
https://www.acmicpc.net/problem/1812

브루트 포스로 모든 인원을 확인해서 한 사람의 사탕이 몇개인지 식을 세워야 한다.
만약 3명이 있고 입력이 a, b, c로 주어졌을 때, 1번째 인원의 사탕을 x개로 두면 2번째 인원의 사탕은 a-x개이다.
그리고 3번째 인원은 b-(a-x)=b-a+x이고, 1번째 인원의 사탕은 c-(b-a+x)=c-b+a-x=x => c-b+a=2x => (c-b+a)/2=x 가 된다.
이렇게 n은 3이상의 홀수이므로 홀수번째 입력은 더하고 짝수번째 입력은 빼면서 모든 값을 확인하고 결과를 2로 나누면 1번째 인원이 가진 사탕의 개수가 된다.
그 개수를 활용해 모든 인원의 사탕 개수를 출력한다.

*/

fun main() {
    val n = readln().toInt()
    val candy = IntArray(n) { readln().toInt() }
    var sum = 0
    repeat(n) {
        if (it % 2 == 1) sum -= candy[it]
        else sum += candy[it]
    }
    var c = sum / 2
    candy.forEach {
        println(c)
        c = it - c
    }
}

/*

*/