"""

골뱅이 찍기 - 뒤집힌 ㄱ

"""

import sys

N = int(sys.stdin.readline())

for i in range(N):
    print("@"*5*N)

for i in range(4 * N):
    print("@"*N)
