"""

특별상이라도 받고 싶어

재귀함수 이용

"""



import sys


def choice(top: int, left: int, length: int) -> int:
    if length == 1:
        return pos[top][left]
    else:
        halfLength = int(length / 2)
        temp = [choice(top, left, halfLength), choice(top + halfLength, left, halfLength),
                choice(top, left + halfLength, halfLength), choice(top + halfLength, left + halfLength, halfLength)]

    temp.sort()
    return temp[1]


N = int(sys.stdin.readline())
pos = list()
for _ in range(N):
    pos.append(list(map(int, sys.stdin.readline().split())))

print(choice(0, 0, N))
