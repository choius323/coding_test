/*

25194번 - 결전의 금요일
https://www.acmicpc.net/problem/25194

완전 탐색과 비둘기 집의 원리로 풀었다.
비둘기 집의 원리로 7의 배수가 아닌 일이 7개 이상 있으면 일을 금요일에 끝낼 수 있다.
그 이하일 때는 모두 계산하면 되지만 6개 이하이기 때문에 대부분의 방법은 시간 안에 풀 수 있다.
값을 저장할 때는 7의 배수인 값이 많이 들어오면 재귀함수가 많이 돌기 때문에 그 외의 값만 저장해야 한다.

이 외에도 0-1 배낭 문제를 사용하면 해결할 수 있다.

also, apply 등을 사용할 때 위치에 주의하자.

*/

package baekjoon_kotlin._25000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val arr = ArrayList<Int>()
    repeat(i()) { (i() % 7).also { if (it != 0) arr.add(it) } }
    var answer = arr.size > 6
    fun dfs(day: Int, index: Int) {
        if (day % 7 == 4) answer = true
        else for (i in index until arr.size)
            if (!answer) dfs((day + arr[i]) % 7, i + 1)
    }
    dfs(0, 0)
    print(if (answer) "YES" else "NO")
}

/*
8
1 7 7 7 7 7 7 7
*/