"""

14467번 - 소가 길을 건너간 이유 1
https://www.acmicpc.net/problem/14467



"""

import sys

cow = [-1]*11
count = 0
for _ in range(int(sys.stdin.readline())):
    a, b = map(int, sys.stdin.readline().split())
    if cow[a] == -1:
        cow[a] = b
    elif cow[a] != b:
        count += 1
    cow[a] = b
    print(cow)
print(count)

"""

"""