/*

1633번 - 최고의 팀 만들기
https://www.acmicpc.net/problem/1633
분류 : 다이나믹 프로그래밍

dp를 각 팀의 인원 수를 인덱스로 하는  2차원 배열로 만들어서 해당 인원 수일 때 최대 점수를 저장한다.
-> dp[5][3] : w팀 5명, b팀 3명을 골랐을 때 능력치 합의 최댓값
입력을 받는동안 매번 전체 dp를 갱신하며 최대 점수를 찾는다.
dp는 뒤에서부터 갱신해야 같은 사람을 여러번 더하지 않는다.

*/

fun main() = System.`in`.bufferedReader().run {
    val dp = Array(16) { IntArray(16) }
    while (ready()) {
        val temp = Array(16) { IntArray(16) }
        val (white, black) = readLine().trim().split(" ").map(String::toInt)
        for (w in 15 downTo 0) for(b in 15 downTo 0) {
            temp[w][b] = maxOf(dp[w][b], if(w == 0) 0 else (dp[w - 1][b] + white), if(b == 0) 0 else (dp[w][b - 1] + black))
        }
        temp.copyInto(dp)
    }
    print(dp[15][15])
}

/*

*/