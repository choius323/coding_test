package baekjoon_kotlin._2000/*

2877번 - 4와 7
https://www.acmicpc.net/problem/2877

1을 더한 뒤 2진수로 변환하고 2번째 글자부터 0을 1로, 1을 7로 바꿔서 출력하면 된다.
1을 더하는 이유는 4를 0, 7을 1처럼 쓰기 때문에 1을 빼야 하지만 그럴 경우 앞자리가 생략 되면서 자리수가 바뀔 수 있기 때문이다.

*/

fun main() {
    val k = (readln().toInt() + 1).toString(2)
    val sb = StringBuilder()
    for (i in 1 until k.length) {
        sb.append(if (k[i] == '0') '4' else '7')
    }
    print(sb)
}

//fun main()=print((readln().toInt()+1).toString(2).replace('0','4').replace('1','7').drop(1))

/*

*/