"""
롤 케이크
"""
L = int(input())
N = int(input())
audiences = [list(map(int, input().split())) for _ in range(N)]

cakeList = [audiences[i][1] - audiences[i][0] for i in range(len(audiences))]
print(cakeList.index(max(cakeList)) + 1)

cake = [0] * L
cakeList = list()
for a, b in audiences:
    count = 0
    for i in range(a - 1, b):
        cake[i] += 1
        if cake[i] == 1:
            count += 1
    cakeList.append(count)
print(cakeList.index(max(cakeList)) + 1)
