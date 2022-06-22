/*

2981번 - 검문
https://www.acmicpc.net/problem/2981

나머지 정리와 유클리드 호제법으로 나머지를 같게 만드는 최대 공약수를 구한다.

나머지 정리는 A=Ma+r1, B=Ba+r2로 표현할 때 A-B=M(a-b)+r1-r2가 되고 r1=r2이면 A-B는 M으로 나누어 떨어진다는 내용이다.
따라서 0<k<n에 대해 모든 num[k]-num[k-1]의 약수는 모두 나머지를 같게 만든다.

약수는 유클리드 호제법으로 구하며 a>b일 때, a와 b의 약수는 a%b와 b의 약수라는 내용이다.

마지막으로 최대 공약수의 약수는 1~n까지 직접 나누며 계산해야 한다.
또는 1~n^0.5 까지 나누며 나누어 떨어지는지 계산하고 나누어 떨어진다면 다시 그 수로 나눈 수 또한 약수가 된다는 점을 이용하면 된다.
한 마디로 a/b=c이면 a/c=b라는 점을 이용하는 것이다. 대신 b=c일 때 b가 2번 출력될 수 있으니 조심해야 한다.
이 문제에선 m이 항상 1보다 크기 때문에 2부터 나눠보고 마지막 수는 따로 추가하면 된다.

*/

package baekjoon_kotlin

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    fun gcd(a: Int, b: Int): Int = if (b % a != 0) gcd(b % a, a) else a

    val n = i()
    val nums = IntArray(n) { i() }.sortedArray()

    var g = nums[1] - nums[0]
    for (i in 1..n - 2)
        g = gcd(g, nums[i + 1] - nums[i])

    val sb = StringBuilder()
    val answer = ArrayList<Int>()
    var i = 2
    while (i * i <= g) {
        if (g % i == 0) {
            sb.append("$i ")
            if (i * i != g)
                answer.add(g / i)
        }
        i++
    }
    answer.reversed().forEach { sb.append("$it ") }
    print("$sb$g")
}

/*
4
8 71 701 491
*/