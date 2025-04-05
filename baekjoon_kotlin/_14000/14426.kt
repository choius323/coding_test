package baekjoon_kotlin._14000

/*

14426번 - 접두사 찾기
https://www.acmicpc.net/problem/14426
분류 : 자료 구조, 문자열, 트리, 이분 탐색, 트라이

트라이 구조에 집합 S의 n개 문자를 모두 넣고, m개 문자를 각각 접두사가 있는지 확인한다.
트라이는 문자, 하위 트라이를 변수와 문자열 추가, 문자열 탐색 함수를 갖는다.

트라이를 사용하지 않으면, 이진 탐색을 사용해서 풀 수 있다.
집합 S를 문자열 순으로 정렬하고, m개의 문자열을 집합 S에서 이진 탐색으로 확인하며 각 문자의 접두어가 되는지 확인한다.

*/

private class Trie(val char: Char, val nodes: MutableList<Trie> = mutableListOf(), var count: Int = 0) {
    val isEnd get() = nodes.isEmpty()
    fun findWord(str: String): Boolean {
        if (str.isEmpty()) return true
        if (isEnd) return false
        for (node in nodes) {
            if (node.char == str.first() && node.findWord(str.drop(1))) {
                return true
            }
        }
        return false
    }

    fun addWord(str: String) {
        if (str.isEmpty()) {
            count++
            return
        }
        for (node in nodes) {
            if (node.char == str.first()) {
                node.addWord(str.drop(1))
                return
            }
        }
        val nextTrie = Trie(str.first())
        nodes += nextTrie
        nextTrie.addWord(str.drop(1))
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map(String::toInt)
    val trie = Trie(' ')
    repeat(n) {
        trie.addWord(readLine())
    }
    print(List(m) { readLine() }.count { trie.findWord(it) })
}

/*

*/