/*

1780번 - 종이의 개수
https://www.acmicpc.net/problem/1780

dfs를 활용하는 문제다.
isSame 값을 받아오는 부분을 또 다른 함수로 만들고 return 값을 if(isSame) 부분에 바로 넣는 방법도 있다.
이번 dfs에는 return을 쓰지 않아도 됐고 반복문이 많이 들어가서 시간 초과가 발생하지 않을까 생각했는데 그렇진 않았다.

 */


package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

var answer = Array(3) { 0 }
lateinit var paper: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    paper = Array(n) {
        br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    dfs(0, 0, n)

    answer.forEach { println(it) }
}

private fun dfs(l: Int, t: Int, len: Int) {
    var isSame = true
    isSameLoop@for (b in t until t+len){
        for (a in l until  l + len){
            if (paper[t][l] != paper[b][a]){
                isSame = false
                break@isSameLoop
            }
        }
    }
//    println("l : $l\tt : $t\tlen : $len\tisSame : $isSame")
//    println(answer.contentToString())
    if (isSame) {
        answer[paper[t][l]+1] += 1
    } else{
        for (b in arrayOf(t, t+len/3, t+len*2/3)){
            for (a in arrayOf(l, l+len/3, l+len*2/3)){
                dfs(a, b, len/3)
            }
        }
    }
}

/*
9
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1

10
12
11
 */