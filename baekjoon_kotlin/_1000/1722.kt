package baekjoon_kotlin._1000

/*

1722번 - 순열의 순서
https://www.acmicpc.net/problem/1722
분류 : 수학, 구현, 조합론

n자리수로 만들 수 있는 순열은 n!개의 경우의 수가 있으며, 한 자리를 확정하면 (n-1)!개의 경우의 수가 있다.
또한 문제에서는 작은 숫자부터 차례대로 찾으면 된다.
따라서 현재 찾으려는 숫자 or 순열의 순서를 찾기 위해서 나머지 자리의 경우의 수에 따라 현재 찾는 숫자 or 순서가 정해진다.

정확히는 찾는 숫자보다는 사용 가능한 숫자 중 몇번째 인지가 가장 중요하다.
https://dreamtreeits.tistory.com/211

*/

fun main() {
    val n = readln().toInt()

    val kinds = LongArray(n + 1)
    kinds[0] = 1
    for (i in 1..n) {
        kinds[i] = kinds[i - 1] * i
    }
    kinds.reverse()

    fun solve(k: Long) {
        val answer = IntArray(n)
        var count = k
        val nums = MutableList(n) { it + 1 }
        for (idx in 0 until n) {
            val kind = kinds[idx + 1]
            val step = ((count - 1) / kind).toInt()
            answer[idx] = nums[step]
            nums.removeAt(step)
            count -= kind * step
        }
        print(answer.joinToString(" "))
    }

    fun solve(inputNums: IntArray) {
        val useNums = MutableList(n) { it + 1 }
        var answer = 1L
        for (idx in 0 until n) {
            val kind = kinds[idx + 1]
            val step = useNums.indexOf(inputNums[idx])
            useNums.remove(inputNums[idx])
            answer += kind * step
        }
        print(answer)
    }

    val input = readln().split(" ")
    when (input[0]) {
        "1" -> solve(input[1].toLong())
        "2" -> solve(input.slice(1..n).map { it.toInt() }.toIntArray())
    }
}

/*
1 2 3   1
1 3 2   2
2 1 3   3
2 3 1   4
3 1 2   5
3 2 1   6

1 2 3 4   1
1 2 4 3   2
1 3 2 4   3
1 3 4 2   4
1 4 2 3   5
1 4 3 2   6
2 1 3 4   7
2 1 4 3   8
2 3 1 4   9
2 3 4 1   10
2 4 1 3   11
2 4 3 1   12
3 1 2 4   13

20
1 2432902008176639999
20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1

2432902008176639999
2432902008176640000
2432902008176640001

*/