package baekjoon_kotlin._3000

/*

3671번 - 산업 스파이의 편지
https://www.acmicpc.net/problem/3671
분류 : 수학, 브루트포스 알고리즘, 정수론, 조합론, 소수 판정, 에라토스테네스의 체

먼저 에라토스테네스의 체로 1~7자리 수가 소수인지 각각 확인한다.
이후 종이 조각의 숫자로 만들 수 있는 모든 수를 만들며 각각 확인한다.

중복을 제거하는 방법은 2가지가 있다.
만든 숫자를 모두 Set에 넣는다.
크기가 1000_0000인 배열을 만들어서 나온 숫자를 체크한다.


*/

fun main() {
    fun countPrime(str: String, subStr: String, checked: BooleanArray, countCheck: Int, isPrimes: BooleanArray): Int {
        var sum = 0
        val num = subStr.toIntOrNull()
        if (num != null && isPrimes[num]) {
            sum += 1
            isPrimes[num] = false
        }
        if ((subStr.lastOrNull()?.digitToIntOrNull() ?: 1) % 2 == 0) return sum
        for (idx in str.indices) {
            if (checked[idx]) continue
            checked[idx] = true
            val nextSubStr = str[idx] + subStr
            sum += countPrime(str, nextSubStr, checked, countCheck + 1, isPrimes)
            checked[idx] = false
        }
        return sum
    }

    val isPrimes = BooleanArray(10000000) { true }
    isPrimes[0] = false
    isPrimes[1] = false

    for (num in 2..isPrimes.lastIndex) {
        if (isPrimes[num].not()) continue
        isPrimes[num] = true
        var multi = num * 2
        while (multi < isPrimes.size) {
            isPrimes[multi] = false
            multi += num
        }
    }

    val temp = BooleanArray(isPrimes.size)
    repeat(readln().toInt()) { _ ->
        val input = readln()
        isPrimes.copyInto(temp)
        println(countPrime(input, "", BooleanArray(input.length), 0, temp))
    }
}

/*

*/