"""

24678번 - 돌무더기 게임 1

"""


import sys

for _ in range(int(sys.stdin.readline())):
    stone = sorted(list(map(int, sys.stdin.readline().split())))
    if stone[1] == 0:
        print("R")
    elif all(s % 2 == 0 for s in stone):
        print("R")
    elif all(s % 2 == 1 for s in stone):
        print("B")
    else:
        print("B" if sum(stone) % 2 == 0 else "R")
