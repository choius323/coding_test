package baekjoon_kotlin._3000/*

3052번 - 나머지
https://www.acmicpc.net/problem/3052

입력받은 수의 나머지를 저장한 배열을 셋으로 바꾸고 크기를 출력한다.

*/

//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run { print(List(10) { nextToken();nval.toInt() % 42 }.distinct().size) }
fun main()=print(List(10){readln().toInt()%42}.toSet().size)

/*

*/