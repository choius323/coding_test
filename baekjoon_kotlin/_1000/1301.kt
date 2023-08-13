package baekjoon_kotlin._1000/*

1301번 - 비즈 공예
https://www.acmicpc.net/problem/1301
https://velog.io/@choius323/Kotlin-%EB%B0%B1%EC%A4%80-1301%EB%B2%88-%EB%B9%84%EC%A6%88-%EA%B3%B5%EC%98%88

참고 링크:
https://gusdnr69.tistory.com/188
https://velog.io/@yanghs0540/%EB%B0%B1%EC%A4%80-%EB%B9%84%EC%A6%88-%EA%B3%B5%EC%98%881301

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i() //구슬 종류의 수
    val beads = IntArray(6) //구슬 종류 별 개수. 인덱스:구슬 번호, 값:남은 개수. 0번은 선택하지 않았을 때를 위해 비워둔다.
    repeat(n) { beads[it + 1] = i() }
    val dp =
        Array(beads[1] + 1) { //1번 구슬의 개수
            Array(beads[2] + 1) { //2번 구슬의 개수
                Array(beads[3] + 1) { //3번 구슬의 개수
                    Array(beads[4] + 1) { //4번 구슬의 개수
                        Array(beads[5] + 1) { //5번 구슬의 개수
                            Array(n + 1) { LongArray(n + 1) { -1 } } // 이전 구슬 2개의 종류
                        }
                    }
                }
            }
        } //dp의 결과를 저장 할 배열. 각각 구슬의 개수와 이전에 선택한 구슬에 따른 경우의 수를 저장한다.
    val sum = beads.sum() //총 구슬의 수

    fun dfs(length: Int, bead1: Int, bead2: Int): Long { //선택한 구슬의 수, 2개 전 구슬의 종류, 직전 구슬의 종류
        if (length == sum) return 1 //구슬을 모두 사용했다면 1을 반환
        if (dp[beads[1]][beads[2]][beads[3]][beads[4]][beads[5]][bead1][bead2] != -1L) //현재 상황을 미리 확인했다면
            return dp[beads[1]][beads[2]][beads[3]][beads[4]][beads[5]][bead1][bead2] //미리 저장된 값 반환
        var count = 0L //현재 상황에서 나오는 경우의 수
        for (i in 1..n) {
            if (i != bead1 && i != bead2 && beads[i] > 0) { //i 번째 구슬이 앞과 겹치지 않고 개수가 남아있다면
                beads[i]-- //구슬 사용
                count += dfs(length + 1, bead2, i) //재귀함수를 호출하며 이후의 상황에서 나온 경우의 수까지 추가
                beads[i]++ //사용한 구슬 다시 추가
            }
        }
        dp[beads[1]][beads[2]][beads[3]][beads[4]][beads[5]][bead1][bead2] = count //현재 상황에서 나오는 경우의 수 저장
        return count
    }
    print(dfs(0, 0, 0))
}

/*

*/