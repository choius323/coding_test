/*

64065번 - 튜플
https://school.programmers.co.kr/learn/courses/30/lessons/64065

처음과 마지막 괄호를 제외하면 문자열을 "},{"로 나눴을 때 각 튜플로 리스트가 만들어진다.
그 리스트를 다시 ","으로 나누고 Int로 바꾸면 원래 자료형으로 된다.
kotlin의 setOf()와 mutableSetOf()로 생성되는 Set은 LinkedHashSet()이므로 순서가 보장된다.
따라서 변환한 튜플들을 크기순으로 정렬하고 Set에 순서대로 넣으면 문제의 정답이 나온다.

*/

//private class Solution64065 {
//    fun solution(s: String): IntArray {
//        val tuples =
//            """(\{[\d,]+})""".toRegex().findAll(s).toList()
//                .map { match ->
//                    match.groupValues.drop(1)
//                        .map { it.drop(1).dropLast(1) }
//                }.map { it[0].split(",").map { str -> str.toInt() } }
//                .sortedBy { it.size }
//        val set = HashSet<Int>(tuples.size)
//        val answer = IntArray(tuples.size)
//        for (i in tuples.indices) {
//            tuples[i].forEach {
//                if (it !in set) {
//                    answer[i] = it
//                    set += it
//                }
//            }
//        }
//        return answer
//    }
//}

private class Solution64065 {
    fun solution(s: String): IntArray {
        return s.drop(2).dropLast(2).split("},{")
            .map { it.split(",").map { it.toInt() } }
            .sortedBy { it.size }
            .fold(setOf<Int>()) { set, list -> set + list }
            .toIntArray()
    }
}

fun main() {
    Solution64065().apply {
        println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))
    }
}

/*

*/