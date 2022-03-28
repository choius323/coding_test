package baekjoon_kotlin

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val numArr = Array(scanner.nextInt()) { scanner.nextInt() }
    var count = 0
    numArr.forEach {
        if (it == 2 || it == 3) {
            count += 1
        } else if (it > 3 && it % 2 != 0) {
            var isBreak = false
            for (i in 3..it / 2) {
                if (it % i == 0) {
                    isBreak = true
                    break
                }
            }
            if (!isBreak) {
                count += 1
            }
        }
//        println("$it $count")
    }
    print(count)
}