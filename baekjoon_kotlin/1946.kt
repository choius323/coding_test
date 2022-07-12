/*

1946번 - 신입 사원
https://www.acmicpc.net/problem/1946

그리디를 활용하는 문제이며 모든 지원자보다 서류나 면접 순위 중 적어도 하나가 더 높아야한다.
지원자의 서류 순위를 인덱스로 갖고, 면접 순위를 값으로 갖는 배열을 만든다.
그 배열을 순차적으로 돌며 max보다 작은 값을 가지면 count를 1 증가하고 max를 갱신한다.
max보다 작은 값을 갖는다면 그 사원은 적어도 다른 max 순위를 가진 지원자보다 면접 순위가 더 높다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val sb = StringBuilder()
    repeat(i()) {
        val n = i()
        val applicant = IntArray(n)
        repeat(n) { applicant[i() - 1] = i() - 1 }
        var count = 0
        var max = 99999999
        for (i in applicant) {
            if (i < max) {
                max = i
                count++
            }
        }
        sb.appendLine(count)
    }
    print(sb)
}

/*
2
5
3 2
1 4
4 1
2 3
5 5
7
3 6
7 3
4 2
1 4
5 7
2 5
6 1

*/