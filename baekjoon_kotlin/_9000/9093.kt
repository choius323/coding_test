package baekjoon_kotlin._9000/*

9093번 - 단어 뒤집기
https://www.acmicpc.net/problem/9093

영어가 나오면 배열에 저장하고 ' '나 '\n'가 나오면 저장된 배열을 거꾸로 출력하고 입력받은 ' '나 '\n'를 출력한다.
배열을 출력하고 난 뒤에는 배열을 다시 초기화 한다.

*/

fun main() = System.`in`.bufferedReader().run {
    val bw = System.out.bufferedWriter()
    val arr = ArrayList<Char>()
    readLine()
    while (ready())
        when (val c = read().toChar()) {
            ' ', '\n' -> {
                for (i in arr.lastIndex downTo 0) bw.append(arr[i])
                bw.append(c)
                arr.clear()
            }

            else -> arr += c
        }
    bw.flush()
}

/*

*/