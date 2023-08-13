package baekjoon_kotlin._1000/*

1535번 - 안녕
https://www.acmicpc.net/problem/1535

체력과 행복으로 배열을 만든 뒤 체력을 기준으로 내림차순 정렬을 한다.
dp 배열은 0~99까지 체력을 소모했을 때 얻을 수 있는 행복을 저장한다.
역순으로 정렬된 사람을 foreach로 반복하며 99->체력까지 현재 dp와 체력을 소모했을 때 얻는 행복 중 큰 값을 dp에 저장한다.
dp의 마지막 원소를 출력하면 된다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class People(val hurt: Int, var happy: Int)

    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val people = Array(n) { People(i(), 0) }
    repeat(n) { people[it].happy = i() }
    people.sortBy { -it.hurt }
    val dp = IntArray(100)
    for ((hurt, happy) in people)
        for (d in 99 downTo hurt) {
            dp[d] = maxOf(dp[d], happy + dp[d - hurt])
        }
    print(dp[99])
}

/*

*/