"""
어항 문제



"""

# 90도 회전 및 공중부양
def leviation90(index: int):
    # topIndex = max(row for row in range(len(fishes)) if fishes[row][0] is not None)
    topIndex = len(fishes)
    [
        fishes.append([])
        for _ in range(index - len(fishes) + 1)
        if index + 1 > len(fishes)
    ]
    for row in range(topIndex):
        for col in range(index):
            fishes[index - col] += [fishes[row].pop(0)]


# 180도 회전 및 공중부양
def levitation180():
    topIndex = len(fishes)
    index = len(fishes[0]) // 2
    [fishes.append([]) for _ in range(topIndex)]
    for row in range(topIndex):
        for col in range(index - 1, -1, -1):
            # fishes[2 * topIndex - row - 1][2 * index - col - 1] = fishes[row][col]
            # index - row + index - 1 => 2 * index - row - 1
            fishes[2 * topIndex - row - 1] += [fishes[row].pop(col)]


# 물고기 분배
def divide():
    fishesModi = [[0] * len(temp) for temp in fishes]

    for row in range(len(fishes)):
        for col in range(len(fishes[row])):
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
            if row < len(fishes) - 1 and len(fishes[row + 1]) > col:
                fishesModi[row][col] += addFishes(
                    fishes[row][col], fishes[row + 1][col]
                )

    for row in range(len(fishes)):
        for col in range(len(fishes[row])):
            fishes[row][col] += fishesModi[row][col]
    toFloor()

    # print(fishesModi)
    # print(fishes)


# 계산
def addFishes(a, b):
    if a >= b:
        return -((a - b) // 5)
    elif b > a:
        return (b - a) // 5


# 바닥에 재정렬
def toFloor():
    sliceIndex = len(fishes[len(fishes) - 1])
    index = 1
    for _ in range(sliceIndex):
        for row in range(1, len(fishes)):
            fishes[0].insert(index, fishes[row].pop(0))
            index += 1
        index += 1
    [fishes.pop() for i in range(len(fishes) - 1)]
    # print(fishes)


# 값 입력
N, K = map(int, input().split())
fishes = [list(map(int, input().split()))]


count = 0
while True:
    minFish = min(fishes[0])
    while fishes[0].count(minFish) > 0:
        fishes[0][fishes[0].index(minFish)] = minFish + 1
    # print(fishes)

    n = 2
    while len(fishes) <= len(fishes[0]) - n // 2:
        leviation90(n // 2)
        n += 1
        # print(fishes)

    divide()

    count += 1
    for _ in range(2):
        levitation180()
        # print(fishes)
    divide()

    maxFish = max(fishes[0])
    minFish = min(fishes[0])
    if maxFish - minFish <= K:
        break

# print(fishes)
print(count)
