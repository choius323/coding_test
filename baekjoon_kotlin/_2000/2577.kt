package baekjoon_kotlin._2000/*

2577번 - 숫자의 개수
https://www.acmicpc.net/problem/2577

3가지 수를 곱한 뒤 string으로 바꾸고 문자를 char로 변환하고 각 인덱스에 맞게 answer의 값을 더하면된다.

*/

fun main(){
    val answer = IntArray(10)
    fun i() = readln().toInt()
    (i()*i()*i()).toString().forEach { answer[it-'0']++ }
    answer.forEach { println(it) }
}

/*

*/