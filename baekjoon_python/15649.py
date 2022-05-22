"""

15649번 - N과 M (1)
https://www.acmicpc.net/problem/15649

중복없이 n까지의 수를 m개 고르면 되고 재귀함수를 사용했다.

itertools.permutations를 사용해서 순열을 구하면 더 쉽게 풀 수 있다.

"""

import sys

n, m = map(int, input().split())
visited = [False] * (n + 1)


def recur(count, ans):
    if count == m:
        sys.stdout.write(ans + "\n")
        return
    for i in range(1, n + 1):
        if not visited[i]:
            visited[i] = True
            recur(count + 1, ans + str(i) + " ")
            visited[i] = False


recur(0, "")
"""

"""
