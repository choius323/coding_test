/*

11727번 - 2xn 타일링 2
https://www.acmicpc.net/problem/11727

맨 앞에 놓는 타일을 가로 1칸으로 설정하면 i-1과 같고, 2칸으로 설정하면 i-2의 2배와 같다
따라서 점화식은 arr[i] = arr[i-1] + arr[i-2]이다.
추가로 배열이 아니라 정수 변수 2개만 사용해도 된다.

*/

package baekjoon_kotlin

fun main() {
    val n = readLine()!!.toInt()
    val arr = IntArray(n)
    arr[0] = 1
    if (arr.size > 1)
        arr[1] = 3
    for (i in 2 until arr.size) {
        arr[i] = (arr[i - 1] + arr[i - 2] * 2)%10007
    }
    println(arr.contentToString())
    println(arr[n - 1])
}