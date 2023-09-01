package baekjoon_kotlin._21000

/*

21939번 - 문제 추천 시스템 Version 1
https://www.acmicpc.net/problem/21939
분류 : 자료 구조, 트리를 사용한 집합과 맵, 우선순위 큐

최소 힙과 최대 힙 2개를 만들고 각각 쉬운 문제, 어려운 문제를 추천할 때 사용한다.
풀지 않은 모든 문제에 대한 난이도를 저장하는 방법을 사용해서, 큐에 있는 문제가 아직 풀지 못한 문제인지 검증한다.

*/

import java.util.*

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Prob(val num: Int, val level: Int) : Comparable<Prob> {
        override fun compareTo(other: Prob) =
            if (level == other.level) {
                num - other.num
            } else {
                level - other.level
            }
    }

    val r = { nextToken();nval.toInt() }
    val s = { r();sval }

    val levels = IntArray(100001)
    val easy = PriorityQueue<Prob>()
    val diff = PriorityQueue<Prob>(reverseOrder())

    fun addProb(prob: Prob) {
        diff += prob
        easy += prob
        levels[prob.num] = prob.level
    }

    fun recommendProb(probNum: Int) {
        val pq: PriorityQueue<Prob> = if (probNum == 1) diff else easy
        while (true) {
            val prob = pq.peek() ?: return
            if (levels[prob.num] == prob.level) {
                println(prob.num)
                return
            }
            levels[prob.num] = 0
            pq.poll()
        }
    }

    repeat(r()) {
        addProb(Prob(r(), r()))
    }
    repeat(r()) {
        val str = s()
        val num = r()
        when (str[0]) {
            'a' -> addProb(Prob(num, r()))
            's' -> levels[num] = -1
            'r' -> recommendProb(num)
        }
    }
}

/*

*/