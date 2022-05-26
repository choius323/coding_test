"""

2477번 - 참외밭
https://www.acmicpc.net/problem/2477

잘리지 않은 원래 길이는 연속으로 나오고, 두 번째 길이를 i라 할 때 i+2, i+3 번째 길이는 잘리 사각형의 크기이다.
파이썬의 음수 인덱스 기능을 사용하면 편하다.
처음과 마지막에 입력한 값이 잘리지 않은 길이일 때를 주의해야 한다.

"""

import sys

r = sys.stdin.readline
k = int(r())
xi = -1
yi = -1
lst = []
for i in range(6):
    d, v = list(map(int, r().split()))
    if d < 3 and (xi == -1 or lst[xi] < v):
        xi = i
    elif d > 2 and (yi == -1 or lst[yi] < v):
        yi = i
    lst.append(v)
mi = max(xi, yi) if abs(xi - yi) == 1 else 0
print(k * (lst[xi] * lst[yi] - lst[mi - 3] * lst[mi - 4]))

"""
7
4 50
2 160
3 30
1 60
3 20
1 100

1
2 50
3 100
1 30
3 60
1 20
4 160
"""
