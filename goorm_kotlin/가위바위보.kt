/*

https://level.goorm.io/exam/43056/%EA%B0%80%EC%9C%84%EB%B0%94%EC%9C%84%EB%B3%B4/quiz/1



*/

fun main() {
    val put = MutableList(3) { 0 }
    readLine()!!.split(" ").forEach { put[it.toInt() - 1]++ }
    print(
        if (put.count { it == 0 } == 0 || put.count { it == 0 } == 2) 0
        else if (put[0] == 0) put[2]
        else if (put[1] == 0) put[0]
        else put[1]
    )
}

/*

*/