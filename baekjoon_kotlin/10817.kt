/*

10817번 - 세 수
https://www.acmicpc.net/problem/10817

수를 모두 입력받고 if나 when을 사용해 분기를 나눠서 출력하거나 sort함수를 사용해 2번째를 출력한다.

*/

fun main()=print(readln().split(" ").map{it.toInt()}.sorted()[1])

/*

*/