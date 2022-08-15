/*

25427번 - DKSH를 찾아라
https://www.acmicpc.net/problem/25427

DK 쌍은 K가 나왔을 때 앞에 있는 D의 개수이고 DKS 쌍은 앞에 있는 DK쌍의 개수만큼 찾을 수 있고 H 또한 마찬가지이다.
따라서 각 글자가 나올 때마다 개수를 더하고 H를 출력하면 된다.

*/

fun main() = System.`in`.bufferedReader().run {
    readLine()
    var (d, k, s, h) = List(4) { 0L }
    for (c in readLine()) when (c) {
        'D' -> d++
        'K' -> k += d
        'S' -> s += k
        'H' -> h += s
    }
    print(h)
}

/*

*/