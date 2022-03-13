"""

토마토

BFS(넓이 우선 탐색) 이용 추천

nextTomato에 익은 토마토의 인덱스를 리스트로 저장하고 다음에 그 곳만 확인하며 반복

"""


import sys

M, N = map(int, sys.stdin.readline().split())

box = list()

for _ in range(N):
    box.append(list(map(int, sys.stdin.readline().split())))

maxValue = 1
nextTomato = [[x, y] for y in range(N) for x in range(M) if box[y][x] == 1]

while len(nextTomato) > 0:
    temp = list()
    for a, b in nextTomato:
        if box[b][a] == maxValue:
            if a > 0 and box[b][a - 1] == 0:
                box[b][a - 1] = maxValue + 1
                temp.append([a - 1, b])
            if a < M - 1 and box[b][a + 1] == 0:
                box[b][a + 1] = maxValue + 1
                temp.append([a + 1, b])
            if b > 0 and box[b - 1][a] == 0:
                box[b - 1][a] = maxValue + 1
                temp.append([a, b - 1])
            if b < N - 1 and box[b + 1][a] == 0:
                box[b + 1][a] = maxValue + 1
                temp.append([a, b + 1])
    nextTomato = temp
    maxValue += 1

print(-1 if any(0 in lst for lst in box) else maxValue - 2)
