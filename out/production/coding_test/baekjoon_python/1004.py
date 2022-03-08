"""

두 지점 중 하나만 원의 반지름 보다 작을 경우만 더한다

"""

import math

T = int(input())
a = [None] * 2
b = [None] * 2
c = [None] * 2
cr = int()
for _ in range(T):
    a[0], a[1], b[0], b[1] = map(float, input().split())
    n = int(input())
    i = 0

    for _ in range(n):
        c[0], c[1], cr = map(float, input().split())
        if (math.dist(a, c) < cr) ^ (math.dist(b, c) < cr):
            i += 1

    print(i)
