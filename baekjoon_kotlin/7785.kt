/*

7785번 - 회사에 있는 사람
https://www.acmicpc.net/problem/7785
분류 : 자료 구조, 해시를 사용한 집합과 맵

HashSet을 사용해 enter일 경우 set에 이름을 더하고 leave일 경우 set에서 이름을 뺐다.
이후 빠지지 않은 명단을 sortedDesceding 함수를 사용해 정렬 후 출력했다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();sval };r()
    val set = hashSetOf<String>()
    repeat(nval.toInt()) {
        val name = r()
        if (r()[0] == 'e') set += name
        else set -= name
    }
    print(set.sortedDescending().joinToString("\n"))
}

/*

*/