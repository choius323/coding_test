/*

17413번 - 단어 뒤집기 2
https://www.acmicpc.net/problem/17413

태그 안에 있는 것들을 출력하고 태그 밖에서는 큐에 넣었다가 출력하면 된다.
when을 사용하는 방법도 있다.

*/

package baekjoon_kotlin._17000

fun main() = System.`in`.bufferedReader().run {
    val str = readLine()
    val sb = StringBuilder()
    var i = 0
    val queue = ArrayDeque<Char>()
    while (i < str.length) {
        if (str[i] == '<') {
            while (i < str.length && str[i] != '>') sb.append(str[i++])
            sb.append(str[i++])
        } else {
            while (i < str.length && str[i] != '<') {
                if (str[i] == ' ') {
                    queue.addFirst(str[i++])
                    break
                }
                queue.add(str[i++])
            }
            while (queue.isNotEmpty()) sb.append(queue.removeLast())
        }
    }
    print(sb)
}

/*

*/