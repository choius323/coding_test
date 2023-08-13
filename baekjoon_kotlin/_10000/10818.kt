package baekjoon_kotlin._10000

/*

10818번 - 최소, 최대
https://www.acmicpc.net/problem/10818

minOf, maxOf 등 기본 함수를 사용하면 편리하다.

*/

//fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
//    var m = Int.MAX_VALUE
//    var M = Int.MIN_VALUE
//    nextToken()
//    repeat(nval.toInt()){
//        nextToken()
//        val n = nval.toInt()
//        m = minOf(m, n)
//        M = maxOf(M, n)
//    }
//    print("$m $M")
//}
fun main(){readln();readln().split(" ").map{it.toInt()}.run{print("${minOf{it}} ${maxOf{it}}")}}

/*

*/