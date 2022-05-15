/*

25192번 - 인사성 밝은 곰곰이
https://www.acmicpc.net/problem/25192

enter 이후에 친 사람을 set에 넣고 크기를 구하면 된다.

*/

package baekjoon_kotlin

fun main() = System.`in`.bufferedReader().run {
    val name = HashSet<String>()
    var count = 0
    repeat(readLine().toInt()) {
        val chat = readLine()
        if (chat == "ENTER") {
            count += name.size; name.clear()
        } else name.add(chat)
    }
    print(count + name.size)
}

/*

*/