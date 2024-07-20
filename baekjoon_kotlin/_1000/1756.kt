package baekjoon_kotlin._1000

/*

1756번 - 피자 굽기
https://www.acmicpc.net/problem/1756
분류 : 구현

피자가 들어간 곳 위에서 시작지점 중에 들어갈 수 있는 가장 낮은 곳에 넣으면 된다.
가장 낮은 곳을 선택하기 위해 0~i번째 지점 중 가장 좁은 곳의 길이를 저장해서 이분 탐색으로 찾았다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val d = r()
    val n = r()
    val oven = IntArray(d) { r() }
    val minDiaArray = DoubleArray(d).apply {
        var minDia = Int.MAX_VALUE
        for (i in 0 until d) {
            minDia = minOf(minDia, oven[i])
            this[i] = minDia.toDouble()
        }
    }.reversedArray()
    val pizzas = IntArray(n) { r() }
    var lastPizzaDeep = oven.size
    for (pizza in pizzas) {
        if (d - lastPizzaDeep > d) break
        val deep = minDiaArray.binarySearch(pizza - 0.5, d - lastPizzaDeep, d).let {
            val idx = if (it < 0) -it - 1 else it
            d - idx - 1
        }
        lastPizzaDeep = deep
    }
    print(lastPizzaDeep + 1)
}

/*

*/