"""

14889번 - 스타트와 링크
https://www.acmicpc.net/problem/14889

dfs로 완전탐색을 하며 모든 조합에 따른 능력치의 차이를 계산하며 가장 작은 수를 출력한다.
여러 방법을 사용해 봤지만 리스트를 직접 전달하는 방법이 속도도 느리지 않고 코드도 알아보기 쉬웠다.
start 배열을 dfs로 돌며 n/2개 까지 채우고 link 배열을 start에 없는 값으로 채운다.
그리고 각각 합계를 모두 더하고 합계의 차를 구한다.

"""

# https://www.acmicpc.net/source/37880837

# import sys
#
#
# def dfs(idx, count):
#     if count == n // 2:
#         si = 0
#         li = 0
#         for i in range(n):
#             if visited[i]:
#                 start[si] = i
#                 si += 1
#             else:
#                 link[li] = i
#                 li += 1
#         result = abs(sum_stat(start) - sum_stat(link))
#         global ans
#         if ans > result:
#             ans = result
#     else:
#         for i in range(idx, n):
#             visited[i] = True
#             dfs(i + 1, count + 1)
#             visited[i] = False
#
#
# def sum_stat(lst):
#     s = 0
#     for a in range(len(lst)):
#         for b in range(a + 1, len(lst)):
#             s += stat[lst[b]][lst[a]]
#     return s
#
#
# n = int(sys.stdin.readline())
# stat = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
# visited = [0] * n
# ans = 99
# for a in range(0, n - 1):
#     for b in range(a + 1, n):
#         stat[b][a] += stat[a][b]
# start = [0] * (n // 2)
# link = [0] * (n // 2)
#
# dfs(0, 0)
# print(ans)

# DFS와 매개변수로 인덱스, 개수 전달
# def dfs(idx, c):
#     if c == n // 2:
#         result = sum_stat()
#         global ans
#         if ans > result:
#             ans = result
#         return
#     elif n - idx < n // 2 - c:
#         return
#     for i in range(idx, n):
#         if not visited[i]:
#             visited[i] = True
#             dfs(i + 1, c + 1)
#             visited[i] = False
#
#
# def sum_stat():
#     start = 0
#     link = 0
#     for a in range(n):
#         for b in range(a + 1, n):
#             if visited[a] and visited[b]:
#                 start += stat[a][b] + stat[b][a]
#             elif not (visited[a] or visited[b]):
#                 link += stat[a][b] + stat[b][a]
#     return abs(start - link)
#
#
# import sys
#
# n = int(sys.stdin.readline())
# stat = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
# visited = [False] * n
# ans = 99
#
# dfs(0, 0)
# print(ans)

# dfs와 매개변수로 인덱스, 리스트 전달
def dfs(idx, start):
    if len(start) == n // 2:
        link = [s for s in range(n) if s not in start]
        result = abs(sum_stat(start) - sum_stat(link))
        global ans
        if ans > result:
            ans = result
    elif n - idx < n // 2 - len(start):
        return
    else:
        for i in range(idx, n):
            dfs(i + 1, start + [i])


def sum_stat(lst):
    s = 0
    for a in lst:
        for b in lst:
            s += stat[b][a]
    return s


import sys

n = int(sys.stdin.readline())
stat = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
ans = 99

dfs(0, [])
print(ans)


# import sys
#
#
# def back_tracking(N, M, stat, n, a_val, all_val, m_val):
#     if M == 0:
#         return min(abs(all_val - a_val), m_val)
#     if N - n < M:
#         return m_val
#
#     for i in range(n, N):
#         m_val = back_tracking(N, M - 1, stat, i + 1, a_val + stat[i], all_val, m_val)
#         if m_val == 0:
#             return 0
#
#     return m_val
#
#
# def solution(N, stat):
#     print(*zip(stat))
#     print(*zip(*stat))
#     print(*zip(stat, zip(*stat)))
#     stat = [sum(i) + sum(j) for i, j in zip(stat, zip(*stat))]
#     print(stat)
#     return back_tracking(N, N // 2, stat, 0, 0, sum(stat) // 2, 1e9)
#
#
# IN = int(sys.stdin.readline())
# IStat = [list(map(int, sys.stdin.readline().split())) for _ in range(IN)]
# print(solution(IN, IStat))

"""

"""
