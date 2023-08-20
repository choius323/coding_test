package baekjoon_kotlin._16000/*

16139번 - 인간-컴퓨터 상호작용
https://www.acmicpc.net/problem/16139

DP를 활용해서 문자열의 각 자리마다 지금까지 나왔던 알파벳의 개수를 저장한다.
배열은 count[자리수(0~문자열길이+1)][문자종류(a~z)]
출력은 문자열을 인덱스로 바꾼 뒤 개수의 차이를 출력하면 된다.
주의할 점은 a~b구간을 출력할 때 a와 b자리가 포함되기 때문에 [b]-[a-1]을 해야 한다.
하지만 a-1을 하면 음수가 나올 수 있어서 따로 예외처리를 해야하기 때문에 한칸씩 뒤로 밀어서 [b+1]-[a]를 출력하도록 했다.
-> 0번째 글자는 count[1], 1번째 글자는 count[2]에 들어가 있다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }
    i()
    val s = sval
    val count = ArrayList<Array<Int>>(s.length)
    count.add(Array(26) { 0 })
    for (c in s) {
        count.add(count.last().clone())
        count[count.lastIndex][c - 'a'] += 1
    }
    val sb = StringBuilder()
    repeat(i()) {
        i()
        val i = sval[0] - 'a'
        sb.appendLine(-count[i()][i] + count[i() + 1][i])
    }
    print(sb)
}

/*

*/