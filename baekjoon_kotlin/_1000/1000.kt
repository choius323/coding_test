package baekjoon_kotlin._1000

fun main() {
    /*val s: String? = readLine()
    val arr:List<String>? = s?.split(" ")
    val a: Int? = arr?.get(0)?.toInt()
    val b: Int? = arr?.get(1)?.toInt()
    print("${b?.let { a?.plus(it) }}")*/

    val s = readLine()
    val arr = s!!.split(" ")
    val a = arr[0].toInt()
    val b = arr[1].toInt()
    print(a+b)
}