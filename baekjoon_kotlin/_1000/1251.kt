package baekjoon_kotlin._1000/*

1251번 - 단어 나누기
https://www.acmicpc.net/problem/1251
분류 : 구현, 문자열, 브루트포스 알고리즘, 정렬

나눈 단어의 길이가 1이상이 될 수 있는 인덱스 2개의 조합을 찾는다.
찾았다면 단어를 주어진 순서에 맞게 바꾸고 반환하며 가장 작은 문자열을 찾는다.

*/

fun main() {
    fun permutation(str: String, indices: ArrayList<Int>): String? {
        if (indices.size == 2) return listOf(
            str.slice(0..indices[0]),
            str.slice(indices[0] + 1..indices[1]),
            str.slice(indices[1] + 1..str.lastIndex)
        ).joinToString("") { it.reversed() }
        var min: String? = null
        for (i in (indices.lastOrNull() ?: -1) + 1..str.length - 2) {
            indices.add(i)
            min = if (min == null) {
                permutation(str, indices)
            } else {
                minOf(min, permutation(str, indices) ?: continue)
            }
            indices.removeLast()
        }
        return min
    }
    print(permutation(readln(), arrayListOf()))
}

/*

*/