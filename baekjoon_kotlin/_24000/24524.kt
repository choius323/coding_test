package baekjoon_kotlin._24000

/*

24524번 - 아름다운 문자열
https://www.acmicpc.net/problem/25424
분류 : 그리디 알고리즘, 문자열

S의 모든 문자를 확인하면서 T에 있는 문자인지 확인하고, 맞다면 앞에 나온 문자들로 T를 만들 수 있는지 확인한다.
우선 T의 각 문자를 key로 하고 나온 횟수를 value로 하는 Map을 저장한다.
이 때 associate는 LinkedHashMap을 사용하기 때문에 순서가 보장된다.
이후 S의 모든 문자를 확인하며 T에 있는 문자인지 map에서 확인한다.
현재 확인할 문자를 c라 할 때, T에서 c보다 앞에 있는 문자가 항상 c보다 더 많이 나와야 하기 때문에 횟수를 확인한다.
이러한 방식으로 S의 모든 문자를 확인하며 최종적으로

*/

fun main() {
    val s = readln()
    val t = readln()
    val countMap = t.associate { it to 0 }.toMutableMap()

    for (c in s) {
        val count = countMap[c] ?: continue
        var isValid = true
        for (entry in countMap) {
            if (c == entry.key) {
                if (isValid)
                    countMap[c] = count + 1
                break
            }
            if (entry.value <= count) {
                isValid = false
                break
            }
        }
    }
    print(countMap.entries.last().value)
}

/*
abbcacb
abc

1
*/