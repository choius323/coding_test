/*

15657번 - N과 M (8)
https://www.acmicpc.net/problem/15657

재귀 함수를 사용하고, 호출할 때는 직전에 넣었던 인덱스를 전달하면 된다.
또, 반복문은 전달받은 인덱스부터 배열의 끝까지 돌면 된다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val m = i()

    val arr = IntArray(n) { i() }
    arr.sort()

    val sb = StringBuilder()

    fun nextStack(index: Int, str: String, count: Int) {
        if (count == m)
            sb.appendLine(str)
//            sb.appendLine(stack.joinToString (" "))
        else
            for (i in index until n)
                nextStack(i, str + arr[i] + ' ', count + 1)
    }

    nextStack(0, "", 0)
    print(sb)

//    val stack = ArrayList<Int>()
//    fun nextStack(index: Int) {
//        if (stack.size == m) {
//            stack.forEach { sb.append("$it ") }
//            sb.append("\n")
////            sb.appendLine(stack.joinToString (" "))
//            return
//        }
//        for (i in index until n) {
//            stack.add(arr[i])
//            nextStack(i)
//            stack.removeLast()
//        }
//    }
//
//    nextStack(0)
//    print(sb)
}

/*
4 3
1 2 3 4
*/