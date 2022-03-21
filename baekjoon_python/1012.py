"""

1012번 - 유기농 배추

파이썬의 재귀 함수는 기본적으로 깊이가 1000까지 지원된다.
이 문제에서 밭의 크기는 50x50까지 가능하므로 최대 깊이는 2501까지 갈 수 있다.
따라서 sys.setrecursionlimit(2501)를 사용해 제한을 늘려주면 된다.

"""


import sys


def moveBug(a, b):
    if a > 0 and field[b][a - 1] == 1:
        field[b][a - 1] = 0
        moveBug(a - 1, b)
    if a < M - 1 and field[b][a + 1] == 1:
        field[b][a + 1] = 0
        moveBug(a + 1, b)
    if b > 0 and field[b - 1][a] == 1:
        field[b - 1][a] = 0
        moveBug(a, b - 1)
    if b < N - 1 and field[b + 1][a] == 1:
        field[b + 1][a] = 0
        moveBug(a, b + 1)


sys.setrecursionlimit(2501)
for _ in range(int(sys.stdin.readline())):
    M, N, K = map(int, sys.stdin.readline().split())
    field = [[0 for a in range(M)] for b in range(N)]
    needBugs = 0
    for _ in range(K):
        a, b = map(int, sys.stdin.readline().split())
        field[b][a] = 1
    # print(field)
    for m in range(M):
        for n in range(N):
            if field[n][m] == 1:
                moveBug(m, n)
                needBugs += 1

    # print(field)
    print(needBugs)
