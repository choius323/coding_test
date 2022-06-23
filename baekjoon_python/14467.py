"""

14467번 - 소가 길을 건너간 이유 1
https://www.acmicpc.net/problem/14467

각 소의 위치를 저장할 배열을 만들고 값이 바뀔 때 count를 늘리면 된다.
단, 배열은 0과 1이 아닌 수로 초기화 해야 한다.

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