/*

17074번 - 정렬
https://www.acmicpc.net/problem/17074

전체를 탐색하며 정렬이 되지 않은 경우를 찾는다.
경우는 크게 3가지 있는데
모두 정렬된 경우(정렬 안 된 숫자가 0개) -> n가지
2번 이상 정렬되지 않은 경우 -> 0가지
1개만 제거해서 정렬되는 경우 -> 1or2가지

모두 정렬된 경우 어떤 숫자를 제거하더라도 되므로 n가지 경우가 있다.
숫자를 단 하나만 제거할 수 있기 때문에 1개만 제거했을 때 정렬되지 않는다면 원하는 답을 찾을 수 없으므로 0가지이다.

1개만 제거해서 정렬되는 경우는 2가지 경우가 있는데 i번째 숫자에서 num[i-1] > num[i]를 발견한 경우
i번째를 빼서 정렬되는 경우 -> num[i-1] <= num[i+1]
i-1번째를 빼서 정렬되는 경우 -> num[i-2] <= num[i]
2가지가 있으며 그 중에 만족되는 경우를 모두 출력한다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val nums = IntArray(n + 2)
    for (it in 1..n) nums[it] = r()
    nums[0] = -1000000000
    nums[n + 1] = 1000000000
    var count = 0
    var index = 0
    for (i in 1..n) {
        if (nums[i - 1] > nums[i]) {
            count++
            index = i
        }
    }
    print(
        if (count == 0) n else if (count > 1) 0
        else {
            (if (nums[index - 1] <= nums[index + 1]) 1 else 0) + if (nums[index - 2] <= nums[index]) 1 else 0
        }
    )
}

/*
4
3 2 3 2
*/