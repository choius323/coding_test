"""

14425번 - 문자열 집합
https://www.acmicpc.net/problem/14425

이분 탐색을 활용한 풀이와 Set을 활용한 풀이가 있다.
Set은 in이 O(1)이기 때문에 가장 빠르다.

이분 탐색은 탐색이 O(nlogn)이기 때문에 Set보다 느리다.
하지만 인덱스가 필요할 때 등 여러가지 활용법이 있기 때문에 중요하다.

추가로 메모리 사용량은 거의 같다.
이분 탐색   35688KB    176ms
Set 활용   36004KB    144ms

"""

# Set을 활용한 풀이
# import sys
#
# i = sys.stdin.readline
#
# n, m = map(int, i().split())
# s = {i() for _ in range(n)}
#
# answer = 0
# for _ in range(m):
#     answer += 1 if i() in s else 0
# print(answer)

# 이분탐색을 활용한 풀이
import sys


def search(target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if target == s[mid]:
            return True
        elif target < s[mid]:
            end = mid - 1
        else:
            start = mid + 1
    return False


i = sys.stdin.readline
n, m = map(int, i().split())
s = sorted([i().rstrip() for _ in range(n)])

answer = 0
for _ in range(m):
    if search(i().rstrip(), 0, n - 1):
        answer += 1
print(answer)

"""

"""
