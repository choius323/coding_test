/*

5355번 - 화성 수학
https://www.acmicpc.net/problem/5355

처음 숫자를 저장하고 그 이후에 나오는 연산자에 따라 값을 변경한다.
String.format을 사용해 소수점을 간편하게 출력할 수 있다.

*/

fun main() = repeat(readln().toInt()) {
    val input = readln().split(" ")
    var num = input[0].toDouble()
    for (i in 1..input.lastIndex)
        when (input[i]) {
            "@" -> num *= 3
            "%" -> num += 5
            "#" -> num -= 7
        }
    print(String.format("%.2f\n", num))
}

/*

*/