package baekjoon_kotlin._17000/*

17298번 - 오큰수
https://www.acmicpc.net/problem/17298
분류 : 자료 구조, 스택

ArrayDeque를 스택으로 사용했다.
입력 순서대로 배열을 돌며 스택을 확인한 뒤 인덱스와 값을 넣는다.
스택을 확인할 때는 스택의 가장 위에 있는 값이 넣으려는 값보다 작은 수가 나오는 동안 계속 제거하며, 제거한 원소의 원래 인덱스에 현재 탐색중인 값의 인덱스를 넣는다.
모든 배열을 다 확인했을 때 스택에 남아있는 값은 오큰수가 없기 때문에 -1을 넣어준다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Element(val index: Int, val num: Int)

    val r = { nextToken();nval.toInt() }
    val nums = IntArray(r()) { r() }
    val stack = ArrayDeque<Element>()
    for ((i, num) in nums.withIndex()) {
        while (stack.isNotEmpty() && stack.last().num < num) {
            nums[stack.removeLast().index] = num
        }
        stack.add(Element(i, num))
    }
    stack.forEach { nums[it.index] = -1 }
    print(nums.joinToString(" "))
}

/*

*/