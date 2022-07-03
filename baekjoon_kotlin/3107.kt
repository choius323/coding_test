/*

3107번 - IPv6
https://www.acmicpc.net/problem/3107

빈 칸은 항상 1개 이상의 생략된 주소가 붙어있다.
생략된 개수는 ":"으로 입력을 나누었을 때 개수와 원래 ip의 개수(8개)와 관련이 있다.
주의할 점은 시작이나 마지막이 생략됐을 때 빈칸이 2개가 나올 수 있다.
padStart(n, c)는 최소 n개의 글자까지 부족한 칸을 앞부터 c로 채워준다.
padEnd도 마찬가지이다.

*/

fun main() = System.`in`.bufferedReader().run {
    val ip = readLine().split(":")
    val sb = StringBuilder()
    for (i in ip.indices)
        if (i != 0 && i != ip.lastIndex && ip[i] == "")
            repeat(9 - ip.size) { sb.append("0000:") }
        else
            sb.append(ip[i].padStart(4, '0') + ":")
    print(sb.deleteAt(39))
}

/*

*/