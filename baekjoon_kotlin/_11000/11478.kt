package baekjoon_kotlin._11000

/*

11478번 - 서로 다른 부분 문자열의 개수
https://www.acmicpc.net/problem/11478
분류 : 자료 구조, 문자열, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵

모든 문자열의 부분 문자열을 확인하며 중복을 제거하기 위해 Set에 넣는다.
마지막에 Set의 크기를 출력한다.

*/

fun main() {
    val str = readln()
    val set = mutableSetOf<String>()
    for (start in 0..str.lastIndex) {
        val sb = StringBuilder()
        for (i in start..str.lastIndex) {
            sb.append(str[i])
            set += sb.toString()
        }
    }
    print(set.size)
}

/*

*/