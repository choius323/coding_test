/*

1931번 - 회의실 배정
https://www.acmicpc.net/problem/1931

모든 경우의 수를 확인해서 결과를 도출할 필요가 없다.
정렬을 끝나는 시간 기준으로 하면 앞에 있는 것들을 넣기만 하면 된다.
모든 경우를 확인하면 시간 초과가 발생한다.
처음에 작성했던 코드가 그렇게 해서 틀린 경우고 심지어 다시봤더니 dfs도 아니었다.

 */

package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val conf = Array(br.readLine().toInt()) { br.readLine().split(" ").map { it.toInt() }.toTypedArray() }
    conf.sortWith ( compareBy( { it[1]}, {it[0]}) )  // 인덱스 1로 정렬. 값이 같으면 인덱스 0으로 정렬.
//    정렬에 필요한 인수가 1개이면 sortBy, 여러개면 sortWith
//    원본 데이터를 유지하고 새로운 배열 반환은 sortedBy, sortedWith
    val answer = ArrayDeque<Int>()
    answer.add(conf[0][1])
    for (i in 1 until conf.size) {
        if (answer.last() <= conf[i][0]) {
            answer.add(conf[i][1])
        }
    }
//    println(conf.contentDeepToString())
//    println(answer.toIntArray().contentToString())
    println(answer.size)
}

//var maxCount = 0
//lateinit var conf: Array<IntArray>
//
//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    conf = Array(br.readLine().toInt()) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
//    conf.sortBy { it[0] }
//    dfsConf(0, 0, 0)
//    println(maxCount)
//}
//
//fun dfsConf(confIndex: Int, count: Int, time: Int) {
//    if (conf.size - confIndex + count <= maxCount) {
//        return
//    } else {
//        if (count > maxCount) {
//            maxCount = count
//        }
//        for (index in confIndex until conf.size) {
//            if (time <= conf[index][0] && (index == 0 || conf[index - 1][0] != conf[index][0])) {
//                dfsConf(index + 1, count + 1, conf[index][1])
//            }
//        }
//    }
//}

/*
15
1 4
0 10
0 0
5 6
3 5
0 6
5 7
3 8
5 9
6 10
5 10
8 11
8 12
2 13
12 14
 */