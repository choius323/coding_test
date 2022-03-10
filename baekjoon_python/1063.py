"""

킹

"""

import sys


def CanMove(move, pos):
    if 1 <= pos + move <= 8:
        return True
    else:
        return False


def ListAdd(list1, list2):
    return list(map(int.__add__, list1, list2))


kPosStr, sPosStr, N = map(str, input().split())
kPos = [ord(kPosStr[0]) - ord("A") + 1, int(kPosStr[1])]
sPos = [ord(sPosStr[0]) - ord("A") + 1, int(sPosStr[1])]
moveDir = [0, 0]
N = int(N)

for i in range(N):
    moveStr = sys.stdin.readline()

    if moveStr.count("L") > 0:
        moveDir[0] = -1
    elif moveStr.count("R") > 0:
        moveDir[0] = +1
    else:
        moveDir[0] = 0

    if moveStr.count("B") > 0:
        moveDir[1] = -1
    elif moveStr.count("T") > 0:
        moveDir[1] = +1
    else:
        moveDir[1] = 0

    if ListAdd(moveDir, kPos) == sPos:
        if CanMove(moveDir[0], sPos[0]) and CanMove(moveDir[1], sPos[1]):
            sPos = ListAdd(moveDir, sPos)
            kPos = ListAdd(moveDir, kPos)
    elif CanMove(moveDir[0], kPos[0]) and CanMove(moveDir[1], kPos[1]):
        kPos = ListAdd(moveDir, kPos)

print(chr(kPos[0] + ord("A") - 1) + str(kPos[1]))
print(chr(sPos[0] + ord("A") - 1) + str(sPos[1]))
