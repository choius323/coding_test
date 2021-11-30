"""

8 7
5 2 3 14 9 2 11 8

"""


def leviation90(index):
    topIndex = max(row for row in range(len(fishes)) if fishes[row][0] is not None)
    for row in range(topIndex + 1):
        for col in range(index):
            fishes[index - col][index + row] = fishes[row][col]  # 모든 행의 같은 컬럼의 값이 같이 바뀜
            fishes[row][col] = None

    # 각 행마다 맨 앞에 None 제거해야함


N, K = map(int, input().split())
fishes = [[None] * N] * N
fishes[0] = list(map(int, input().split()))

minFish = min(value for value in fishes[0] if value is not None)

while fishes[0].count(minFish) > 0:
    fishes[0][fishes[0].index(minFish)] = minFish + 1

leviation90(1)

print(fishes)
