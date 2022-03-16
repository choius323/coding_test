"""

42839번
완전탐색 소수 찾기 문제



set을 이용해서 에라토스테네스 체 만들어서 풀이 가능

"""
from itertools import permutations


def solution(letters):
    answer = 0
    numbers = [list(permutations(letters, i)) for i in range(1, len(letters) + 1)]
    numbers = list(set([int("".join(string)) for string in sum(numbers, [])]))
    numbers.sort()
    print(numbers)

    for number in numbers:
        if number == 2 or number == 3 or number == 5:
            answer += 1
        elif number % 2 == 1 and number >= 7:
            isPrime = True
            for i in range(3, number // 2 + 1):
                if number % i == 0:
                    isPrime = False
                    break
            if isPrime:
                answer += 1

    return answer


print(solution("15"))
