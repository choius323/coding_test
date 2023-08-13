/*

1991번 - 
https://www.acmicpc.net/problem/1991

전위 순회(preorder), 중위 순회(inorder), 후위 순회(postorder)의 차이는 출력을 언제 하는지 밖에 없다.
따라서 같은 하나의 함수로 만들어도 가능하다.

한 쪽으로 치우친 트리를 입력받을 때 완전 이진 트리 처럼 작성하면 메모리를 많이 사용하기 때문에 HashMap을 사용했고 CharArray를 값으로 사용했다.
CharArray는 자식 노드의 값을 저장했다.
다른 방법으로는 트리를 Array(26:최대 노드 수){IntArray(2)}로 선언 하고 IntArray에 자식 노드의 위치를 저장하고, 아스키코드로 변환한 값을 출력하면 된다.

참고로 각 층별 왼쪽부터 순회하는 방법은 층별 순회(level order)라고 한다.

*/

package baekjoon_kotlin._1000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Char {
        nextToken()
        return (sval ?: ".")[0]
    }
    nextToken()
    val tree = HashMap<Char, CharArray>()
    repeat(nval.toInt()) {
        tree[i()] = charArrayOf(i(), i())
    }
    val s = StringBuilder()
//    fun preorder(c: Char) {
//        sb.append(c)
//        for (t in tree[c]!!) {
//            if (t != '.') {
//                preorder(t)
//            }
//        }
//    }
//
//    fun inorder(c: Char) {
//        val (t1, t2) = tree[c]!!
//        if (t1 != '.') {
//            inorder(t1)
//        }
//        sb.append(c)
//        if (t2 != '.') {
//            inorder(t2)
//        }
//    }
//
//    fun postorder(c: Char) {
//        for (t in tree[c]!!) {
//            if (t != '.') {
//                postorder(t)
//            }
//        }
//        sb.append(c)
//    }

    fun order(c: Char, f: Int) {
        val (a, b) = tree[c]!!
        if (f == 0) s.append(c)
        if (a > '.') order(a, f)
        if (f == 1) s.append(c)
        if (b > '.') order(b, f)
        if (f == 2) s.append(c)
    }

//    preorder('A')
//    sb.append("\n")
//    inorder('A')
//    sb.append("\n")
//    postorder('A')
    repeat(3) {
        order('A', it)
        s.append("\n")
    }
    print(s)
}
/*
3
A B .
B C .
C . .
*/