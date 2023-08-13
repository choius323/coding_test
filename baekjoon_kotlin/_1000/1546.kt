package baekjoon_kotlin._1000

fun main() {
    readLine()
    val score = readLine()!!.split(" ").map { it.toFloat() }.toFloatArray()
    val max = score.maxOrNull()!!
    score.forEachIndexed { i, fl -> score[i] = fl / max * 100 }
//    score.forEach { println("$it") }
    println(score.average())
}