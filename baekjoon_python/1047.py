"""

시간 초과...

"""

import math


def minC(coorList):
    temp = 1000000
    tempList = list()
    for i in range(N):
        if i not in cutTrees:
            tempList.append(coorList[i])
    return min(tempList)


def maxC(coorList):
    temp = 0
    tempList = list()
    for i in range(N):
        if i not in cutTrees:
            tempList.append(coorList[i])
    return max(tempList)


N = int(input())
x, y, length = [None] * N, [None] * N, [None] * N
answer = N
for i in range(N):
    x[i], y[i], length[i] = map(int, input().split())

cutTrees = [0]
depth = 1
while len(cutTrees) != N or cutTrees[0] != 0:
    if len(cutTrees) >= answer:
        break

    totalLength = 0
    for i in cutTrees:
        totalLength += length[i]

    minX = minC(x)
    minY = minC(y)
    maxX = maxC(x)
    maxY = maxC(y)

    if (maxX - minX + maxY - minY) * 2 <= totalLength:
        answer = len(cutTrees)

    # print("answer : " + str(answer))

    for index in range(-1, -N - 1, -1):
        # print("[ " + " ".join(map(str, cutTrees)) + " ]     " + str(index))
        if cutTrees[index] == N + index:
            if len(cutTrees) > -index + 1:
                continue
            else:
                cutTrees = [initValue for initValue in range(len(cutTrees) + 1)]
                break
        else:
            cutTrees[index] += 1
            if index != -1:
                for tempIndex in range(index + 1, 0):
                    cutTrees[tempIndex] = cutTrees[index] + tempIndex - index
            break

print(answer)
