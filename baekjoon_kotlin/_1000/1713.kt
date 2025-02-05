package baekjoon_kotlin._1000

/*

1713번 - 후보 추천하기
https://www.acmicpc.net/problem/1713
분류 : 구현, 시뮬레이션

각 후보가 추천 받은 횟수를 저장하는 배열과 추천 횟수를 n개 받은 후보 목록을 저장하는 TreeMap을 만들어 사용했다.
추천 받았을 때 등록되어 있다면 횟수만 갱신하고 등록된 시간은 갱신하지 않는다.
만약, 등록되지 않았다면 등록 수 제한을 확인한다.
여기서 등록 수를 넘어가면 TreeMap에서 가장 작은 수의 배열 중 오래된 후보를 제거한다.
그 후 새로운 후보를 등록해준다.

틀렸던 부분은
1. TreeMap에서 제거됐거나 추천 수가 증가한 후보가 있어서 빈 배열이 남아서 오류가 발생했다.
2. 문제의 3번 조건에서 '가장 오래된 사진'을 해당 횟수 배열에 추가된 지 가장 오래된 것으로 선택했다.
정답은 사진 틀에 등록된 지 가장 오래된 것이다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Candidate(val num: Int, val time: Int)

    val r = { nextToken();nval.toInt() }
    val n = r()
    val counts = java.util.TreeMap<Int, MutableList<Candidate>>()
    val candidates = IntArray(101)
    var candidateCount = 0
    repeat(r()) { time ->
        val candidateNum = r()
        if (candidates[candidateNum] > 0) {
            val count = candidates[candidateNum]
            val candidate = counts[count]!!.first { candidateNum == it.num }
            counts[count]!!.remove(candidate)
            if (counts[count]!!.isEmpty()) counts.remove(count)

            candidates[candidateNum] += 1
            (counts.computeIfAbsent(count + 1) { mutableListOf() }).add(candidate)
        } else {
            if (candidateCount >= n) {
                val minCount = counts.firstKey()
                val removeCandidate = counts[minCount]!!.minBy(Candidate::time)
                counts[minCount]!!.removeIf { it.time == removeCandidate.time }
                candidates[removeCandidate.num] = 0
                candidateCount -= 1
                if (counts[minCount]!!.isEmpty()) counts.remove(minCount)
            }
            (counts.computeIfAbsent(1) { mutableListOf() }).add(Candidate(candidateNum, time))
            candidates[candidateNum] = 1
            candidateCount += 1
        }
    }
    print(counts.values.flatten().map(Candidate::num).sorted().joinToString(" "))
}

/*

*/