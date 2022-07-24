/*

2745번 - 진법 변환
https://www.acmicpc.net/problem/2754

앞글자는 F와 나머지로 나눠서 계산을 하고 뒷글자는 +, -와 없거나 0이 붙을 때로 나눠서 계산한다.
A, B, C, D는 아스키 코드를 기준으로 숫자로 변환한다.

*/

fun main() = print(readln().run {
    when (get(0)) {
        'F' -> 0; else -> -get(0).code + 69
    } + when (getOrNull(1)) {
        '+' -> .3; '-' -> -.3; else -> .0 }
})

//fun main() = print(readln().run {z
//    when (get(0)) {
//        'A' -> 4
//        'B' -> 3
//        'C' -> 2
//        'D' -> 1
//        else -> 0
//    } + when (getOrNull(1) ?: '0') {
//        '+' -> .3
//        '-' -> -.3
//        else -> .0
//    }
//})

/*

*/