"""

43165
깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버

재귀 함수를 사용한 방법

"""


def solution(numbers, target, now=0):
    global answer
    if len(numbers) == 1:
        if now - numbers[0] == target or now + numbers[0] == target:
            answer += 1
    else:
        if now - sum(numbers) <= target <= now + sum(numbers):
            solution(numbers[1:], target, now - numbers[0])
            solution(numbers[1:], target, now + numbers[0])

    return answer


answer = 0

print(solution([4, 1, 2, 1], 4))
