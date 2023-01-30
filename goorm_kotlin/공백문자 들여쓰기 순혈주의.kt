/*

https://level.goorm.io/exam/43055/%EA%B3%B5%EB%B0%B1%EB%AC%B8%EC%9E%90-%EB%93%A4%EC%97%AC%EC%93%B0%EA%B8%B0-%EC%88%9C%ED%98%88%EC%A3%BC%EC%9D%98/quiz/1



*/

fun main() = System.`in`.bufferedReader().run {
    val t = readLine().toInt()
    val sb = StringBuilder()
    while (ready()) {
        val line = readLine().dropLastWhile { it == ' ' || it == '\t' }
        val count = line.takeWhile { it == '\t' }.length
        sb.appendLine(" ".repeat(t * count) + line.substring(count))
    }
    print(sb)
}

/*
2
    println("te st")
  println("te   st")
*/