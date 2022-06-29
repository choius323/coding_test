/*

1068번 - 트리
https://www.acmicpc.net/problem/1068

모든 정점을 확인하며 어떤 셋(삭제된 서브 트리 셋, 삭제되지 않은 서브 트리 셋)에 속하는지 확인한다.
remove에 삭제된 트리의 루트를 넣고 탐색을 하며 이미 셋에 있거나 루트 노드인지 확인하면 된다.
리프 노드는 결국 어떤 트리에도 들어가지 않기 때문에 n에서 두 셋의 개수를 빼면 된다.

DFS로 탐색을 하는 방법도 있다.
우선 삭제된 서브 트리에 속한 정점의 부모를 특정 값으로 바꾸고 루트 노드에서 DFS를 활용해 탐색한다.
부모 노드를 저장한 배열을 모두 확인하며 자식 노드를 찾는다.

n이 50밖에 안 되기 때문에 어떤 방법을 사용해도 오래걸리지 않는다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val parent = IntArray(n) { i() } // 각 노드의 부모 노드를 저장
    val tree = HashSet<Int>() //제거되지 않은 정점
    val remove = HashSet<Int>().apply { add(i()) } // 제거된 정점

    for (i in 0 until n) {
        val sub = ArrayList<Int>() // 탐색한 서브 트리
        var node = i // 탐색할 노드
        while (true) {
            if (node in remove) { // 탐색 중인 노드가 삭제된 트리일 때
                remove.add(i) // 삭제된 트리는 시작 노드도 추가
                remove.addAll(sub)
                break
            } else if (node in tree || parent[node] == -1) { // 탐색 중인 노드가 제거되지 않았거나 루트 노드일 때
                tree.addAll(sub)
                break
            }
            node = parent[node]
            sub.add(node)
        }
    }
    println(tree)
    println(remove)
    print(n - tree.size - remove.size) // 전체 노드 - 리프 노드를 제외한 삭제되지 않은 노드 - 삭제된 노드
}

/*

*/