/*

2941번 - 크로아티아 알파벳
https://www.acmicpc.net/problem/2941

전체 길이에서 입력받은 문자에 알파벳마다 나온 횟수를 빼면 된다.
2글자인 알파벳은 1을 빼면 1글자로 되고, 3글자인 dz=는 z=에서 또 빼주기 때문에 총 2번 빠진 효과가 된다.

*/

fun main() {
    val str = readln()
    val alp = listOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
    var ans = str.length
    for (a in alp)
        for (i in 0..str.length - a.length)
            if (str.substring(i, i + a.length) == a) ans--
    print(ans)
}

/*

*/