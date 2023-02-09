/*

2258번 - 정육점
https://www.acmicpc.net/problem/2258

가격을 기준으로 오름차순 정렬을 하고, 가격이 같으면 무게를 기준으로 내림차순 정렬한다.
그 후에 모든 고기를 확인하며 최적의 해를 구한다.
같은 가격의 고기를 여러개 살 수 있다는 점을 주의해야 하고, 따라서 가장 처음 조건에 맞는 가격이 답이 아닐 수 있다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    data class Meat(val weight: Int, val price: Int)

    val r = { nextToken();nval.toInt() }
    val n = r()
    val m = r()
    val meats = Array(n) { Meat(r(), r()) }
    meats.sortWith(compareBy({ it.price }, { -it.weight }))

    var totalWeight = 0
    var totalPrice = 0
    var lastPrice = -1
    var answer = Int.MAX_VALUE
    for ((weight, price) in meats) {
        totalWeight += weight
        if (lastPrice != price) {
            lastPrice = price
            totalPrice = price
        } else {
            totalPrice += price
        }
        if (totalWeight >= m && totalPrice < answer) {
            answer = totalPrice
        }
    }
    print(if (answer == Int.MAX_VALUE) -1 else answer)
}

/*

*/