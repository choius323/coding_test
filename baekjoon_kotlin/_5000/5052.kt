package baekjoon_kotlin._5000

/*

5052번 - 전화번호 목록
https://www.acmicpc.net/problem/5052
분류 : 자료 구조, 문자열, 정렬, 트리, 트라이

한 전화번호가 다른 전화번호의 접두어가 되려면 전화번호 배열을 정렬했을 때 바로 다음에 와야한다.
만약, 다음 이후에 있다면 그 사이에 있는 전화번호도 접두어이다.

트라이를 사용하는 풀이도 있지만 트리를 구현해야 하기 때문에 메모리를 훨씬 많이 사용하게 된다.

*/

/*
fun main() = System.`in`.bufferedReader().run {
    repeat(readLine().toInt()) {
        val trie = TrieNode()
        for (numStr in Array<String>(readLine().toInt()) { readLine() }.sortedArrayDescending()) {
            if (trie.contains(numStr)) {
                println("NO")
                return@repeat
            }
            trie.add(numStr)
        }
        println("YES")
    }
}

private data class TrieNode(val children: MutableMap<Char, TrieNode> = mutableMapOf()) {
    fun add(word: String, index: Int = 0) {
        if (index == word.length) return
        val char = word[index]
        children.getOrPut(char) { TrieNode() }.add(word, index + 1)
    }

    fun contains(word: String, index: Int = 0): Boolean {
        if (index == word.length) return true
        val char = word[index]
        return children[char]?.contains(word, index + 1) ?: false
    }
}
*/

fun main() = System.`in`.bufferedReader().run {
    repeat(readLine().toInt()) {
        val numbers = Array(readLine().toInt()) { readLine() }.sortedArray()
        for (i in 0..numbers.size - 2) {
            if (numbers[i].length <= numbers[i + 1].length && numbers[i + 1].startsWith(numbers[i])) {
                return@repeat println("NO")
            }
        }
        println("YES")
    }
}

/*

*/