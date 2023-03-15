/*

1034번 - 램프
https://www.acmicpc.net/problem/1034

모든 행을 확인하며 그 행이 모두 켤 수 있는 행인지 확인하고, 켤 수 있다면 나머지 모든 행과 비교해 같은 램프 배열의 개수를 센다.

한 행의 램프를 모두 켜기 위해선 2가지 조건을 만족해야 한다.
1. 꺼져있는 램프보다 누를 수 있는 횟수가 더 많아야 한다. (countOff <= k)
- 당연히 횟수가 부족하면 모든 램프를 켜져있는 상태로 만들 수 없다.
2. 꺼져있는 램프와 누를 수 있는 횟수가 모두 짝수이거나 홀수여야 한다. (countOff % 2 == k % 2)
- 같은 열을 2번 누를 수 있고, 2번 누르면 같은 상태로 된다. 따라서 4번으로 켤 수 있으면 6, 8, 10번으로 켤 수 있다.

위의 조건을 만족하면 나머지 행과 비교하며 램프 배열이 같은지 검사한다.
배열이 다르면 버튼을 어떻게 누르더라도 동시에 모든 램프를 켤 수 없기 때문이다.

*/

fun main() {
    val (n, _) = readln().split(" ").map { it.toInt() }
    val table = Array<String?>(n) { readln() }
    val k = readln().toInt()
    var answer = 0

    for (i in 0 until n) {
        if (table[i] == null) continue
        val countOff = table[i]!!.count { it == '0' }
        if (countOff <= k && countOff % 2 == k % 2) {
            var sameCount = 1
            for (j in i + 1 until n) {
                if (table[i] == table[j]) {
                    sameCount++
                    table[j] = null
                }
            }
            answer = maxOf(sameCount, answer)
        }
    }
    print(answer)
}

/*
fun main() {
    val table = Array(readln().split(" ")[0].toInt()) { readln() }
    val k = readln().toInt()
    print(table.maxOf { line ->
        val countOff = line.count { it == '0' }
        if (countOff <= k && k % 2 == countOff % 2)
            table.count { it == line }
        else
            0
    })
}
*/

/*

*/