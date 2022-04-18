/*

15654번 - N과 M (5)
https://www.acmicpc.net/problem/15654

스택을 사용하면 간단하게 해결할 수 있다.
n<=8이기 때문에 입력받은 배열을 미리 정렬해 주는게 좋다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val m = i()
    val arr = IntArray(n)
    repeat(n) {
        arr[it] = i()
    }
    arr.sort()
    val stack = ArrayList<Int>()
    val sb = StringBuilder()
    fun addStack(index: Int) {
        if (stack.size == m) {
            stack.forEach {
                sb.append("$it ")
            }
            sb.append("\n")
            return
        }
        repeat(n) {
            if (arr[it] !in stack) {
                stack.add(arr[it])
                addStack(index + 1)
                stack.removeLast()
            }
        }
    }
    addStack(0)
    print(sb)
}

/*

*/