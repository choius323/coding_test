/*

2263번 - 트리의 순회
https://www.acmicpc.net/problem/2263

postorder[lp]는 항상 sp~lp까지의 원소를 갖는 서브 트리의 루트이고, sp~lp와 si~li는 서로 같은 서브 트리이다.
따라서 root를 찾은 뒤 출력하고, 그 root의 양쪽 서브트리를 호출하는 재귀 함수를 작성하면 된다.

참고 링크:
https://salguru.tistory.com/140
https://comyoung.tistory.com/248

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val indexArr = IntArray(n + 1) // inorder에 들어온 값의 인덱스
    repeat(n) { indexArr[i()] = it + 1 } // i() : 배열의 index, inorder의 값. it+1 : 배열의 값. inorder에서 값의 인덱스.
    val postorder = IntArray(1) + IntArray(n) { i() }
    val sb = StringBuilder()

    // si : start inorder, li : last inorder, sp: start postorder, lp : last postorder
    fun preorder(si: Int, li: Int, sp: Int, lp: Int) {
        if (si > li) return
        val root = postorder[lp]
        sb.append("$root ")

        val i = indexArr[root]

        preorder(si, i - 1, sp, sp + i - si - 1)
        preorder(i + 1, li, sp + i - si, lp - 1)
    }

    preorder(1, n, 1, n)
    print(sb)
}

/*
3
1 2 3
1 3 2

2 1 3


10
8 4 9 2 10 5 1 6 3 7
8 9 4 10 5 2 6 7 3 1
*/