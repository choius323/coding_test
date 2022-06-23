"""

1388번 - 바닥 장식
https://www.acmicpc.net/problem/1388



"""

import sys

n, m = map(int, sys.stdin.readline().split())
room = [list(sys.stdin.readline()) for _ in range(n)]
count = 0


def change(nx, ny, dx, dy, s):
    while room[ny][nx] == s:
        room[ny][nx] = '.'
        if nx + dx < m and ny + dy < n:
            nx += dx
            ny += dy


for x in range(m):
    for y in range(n):
        if room[y][x] == '-':
            count += 1
            change(x, y, 1, 0, '-')
        elif room[y][x] == '|':
            count += 1
            change(x, y, 0, 1, '|')

print(count)

"""
6 9
-||--||--
--||--||-
|--||--||
||--||--|
-||--||--
--||--||-
"""
