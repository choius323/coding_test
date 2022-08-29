/*

2441번 - 별 찍기 - 4
https://www.acmicpc.net/problem/2441

n개의 줄을 출력하며 i번째 줄은 (i-1)개의 공백과 (n-i+1)개의 별로 이루어져 있다.

*/

private val n=readln().toInt()
fun main()=repeat(n){println(" ".repeat(it)+"*".repeat(n-it))}

/*

*/