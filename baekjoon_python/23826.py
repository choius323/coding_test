"""

와이파이

주어지는 와이파이 개수는 N+1개

(a, b)와 (c, d)의 택시거리는 abs(a-c)+abs(c-d)

"""

import sys

N = int(sys.stdin.readline())
wifi = list()
speed = [0] * (N+1)

for _ in range(N+1):
    wifi.append(list(map(int, sys.stdin.readline().split())))

for b in range(1, N+1):
    if wifi[0][2] > 0:
        speed[b] = max(0, wifi[0][2] - (abs(wifi[b][1] - wifi[0][1]) + abs(wifi[b][0] - wifi[0][0])))

for a in range(1, N+1):
    for b in range(1, N+1):
        if wifi[a][2] > 0:
            speed[b] -= max(0, wifi[a][2] - (abs(wifi[b][1] - wifi[a][1]) + abs(wifi[b][0] - wifi[a][0])))

maxSpeed = max(speed)
print(maxSpeed if maxSpeed > 0 else "IMPOSSIBLE")
