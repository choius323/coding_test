"""

8 7
5 2 3 14 9 2 11 8

TypeError 뜸

"""


def leviation90(index):
    # topIndex = max(row for row in range(len(fishes)) if fishes[row][0] is not None)
    global topIndex
    for row in range(topIndex):
        for col in range(index):
            fishes[index - col][index + row] = fishes[row][col]
            fishes[row][col] = None

    for row in range(index + 1):
        for col in range(index):
            fishes[row].append(fishes[row].pop(0))
    topIndex = index + 1


def levitation180():
    index = rightIndex
    global topIndex
    for row in range(topIndex):
        for col in range(index):
            fishes[2 * topIndex - row - 1][2 * index - col - 1] = fishes[row][col]
            # index - row + index - 1 => 2 * index - row - 1
            fishes[row][col] = None

    for row in range(topIndex * 2):
        for col in range(index):
            fishes[row].append(fishes[row].pop(0))
    topIndex = topIndex * 2


def divide():
    global topIndex
    global rightIndex

    fishesModi = list()
    for row in range(topIndex):
        countNone = 0
        for value in fishes[row]:
            if value is not None:
                countNone += 1
            else:
                break
        fishesModi.append([0] * countNone)
    # fishesModi.pop()

    for row in range(topIndex):
        for col in range(len(fishesModi[row])):
            if col > 0:
                fishesModi[row][col] += addFishes(
                    fishes[row][col], fishes[row][col - 1]
                )
            if col < len(fishesModi[row]) - 1:
                fishesModi[row][col] += addFishes(
                    fishes[row][col], fishes[row][col + 1]
                )
            if row > 0:
                fishesModi[row][col] += addFishes(
                    fishes[row][col], fishes[row - 1][col]
                )
            if row < topIndex - 1:
                fishesModi[row][col] += addFishes(
                    fishes[row][col], fishes[row + 1][col]
                )

    for row in range(topIndex):
        for col in range(len(fishesModi[row])):
            fishes[row][col] += fishesModi[row][col]

    # print(fishesModi)


def addFishes(a, b):
    if b is not None:
        if a >= b:
            return -((a - b) // 5)
        elif b > a:
            return (b - a) // 5
    else:
        return 0


def toFloor(sliceIndex):
    global topIndex
    index = 1
    for _ in range(sliceIndex):
        for row in range(1, topIndex):
            fishes[0].insert(index, fishes[row].pop(0))
            fishes[0].pop()
            fishes[row].append(None)
            index += 1
        index += 1
    topIndex = 1


N, K = map(int, input().split())
fishes = [[None] * N for _ in range(N)]
fishes[0] = list(map(int, input().split()))


count = 0
while True:
    minFish = min(value for value in fishes[0] if value is not None)
    while fishes[0].count(minFish) > 0:
        fishes[0][fishes[0].index(minFish)] = minFish + 1
    # print(fishes)
    topIndex = 1
    rightIndex = N

    n = 2
    while topIndex <= rightIndex - n // 2:
        leviation90(n // 2)
        rightIndex -= n // 2
        n += 1
        # print(fishes)

    divide()
    # print(fishes)
    toFloor(n // 2)
    # print(fishes)

    maxF = max(fishes[0])
    minF = min(fishes[0])
    rightIndex = N // 2
    count += 1
    for _ in range(2):
        levitation180()
        rightIndex //= 2
        # print(fishes)
    divide()
    # print(fishes)
    toFloor(n + 1)
    # print(fishes)
    maxF = max(fishes[0])
    minF = min(fishes[0])
    if maxF - minF <= K:
        break

# print(fishes)
print(count)
