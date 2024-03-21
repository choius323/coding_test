package baekjoon_kotlin._6000

/*

6518번 - 오타 자동 수정
https://www.acmicpc.net/problem/6518
분류 : 자료 구조, 브루트포스 알고리즘, 많은 조건 분기, 해시를 사용한 집합과 맵

사전에 있는 단어를 키, 인덱스를 값으로 하는 해시맵을 만들고, 각 인덱스가 어떤 단어인지 저장하는 배열을 만든다.
확인하려는 단어를 입력하면 우선 사전에서 확인하고 있다면 답을 출력한다.
만약 없다면 단어를 수정해서 사전에 있는 단어로 만들 수 있는지 모든 경우의 수를 확인한 뒤 답을 출력한다.

*/

fun main() = System.`in`.bufferedReader().run {
    val dict = mutableMapOf<String, Int>()
    val dictKeyList = List(readLine().toInt()) {
        readLine().also { str ->
            dict += str to it
        }
    }

    fun getMin(minIdx: Int?, str: String): Int? {
        val removedIdx = dict[str]
        return if (minIdx == null || (removedIdx != null && minIdx > removedIdx)) {
            removedIdx
        } else {
            minIdx
        }
    }

    fun String.findAdd(): Int {
        var minIdx: Int? = null
        for (c in 'a'..'z') {
            for (i in 0..length) {
                val fixed = substring(0, i) + c + substring(i, length)
                minIdx = getMin(minIdx, fixed)
            }
        }
        return minIdx ?: dict.size
    }

    fun String.findRemove(): Int {
        var minIdx: Int? = null
        for (i in indices) {
            val fixed = removeRange(i..i)
            minIdx = getMin(minIdx, fixed)
        }
        return minIdx ?: dict.size
    }

    fun String.findTypo(): Int {
        var minIdx: Int? = null
        for (c in 'a'..'z') {
            for (i in indices) {
                val fixed = substring(0, i) + c + substring(i + 1, length)
                minIdx = getMin(minIdx, fixed)
            }
        }
        return minIdx ?: dict.size
    }

    fun String.findChangePos(): Int {
        var minIdx: Int? = null
        for (i in 0..length - 2) {
            val fixed = substring(0, i) + get(i + 1) + get(i) + substring(i + 2, length)
            minIdx = getMin(minIdx, fixed)
        }
        return minIdx ?: dict.size
    }

    repeat(readLine().toInt()) {
        val original = readLine()
        if (original in dict) {
            println("$original is correct")
        } else {
            val idx = original.run { minOf(findAdd(), findRemove(), findTypo(), findChangePos()) }
            if (idx != dict.size) {
                println("$original is a misspelling of ${dictKeyList[idx]}")
            } else {
                println("$original is unknown")
            }
        }
    }
}

/*

*/