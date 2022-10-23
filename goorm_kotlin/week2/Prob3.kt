package goorm_kotlin.week2

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val d = { nextToken();nval }
    val s = { nextToken();sval }
    val n = d().toInt()
    val k = d().toInt()
    print(List(n) { Person(s(), d()) }.sortedBy { it.height }.sortedBy { it.name }[k - 1])
}

data class Person(val name: String, val height: Double) {
    override fun toString() = "$name ${String.format("%.2f", height)}"
}

