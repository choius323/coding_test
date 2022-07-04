/*

2530번 - 인공지능 시계
https://www.acmicpc.net/problem/2530

초-분-시 순으로 계산하며 몫은 다음 값에 더하고 나머지를 출력하면 된다.

*/

fun main(){
    var (h, m, s) = readln().split(" ").map{ it.toInt() }
    s += readln().toInt()
    m += s / 60
    print("${(h+m/60)%24} ${m%60} ${s%60}")
}

/*

*/