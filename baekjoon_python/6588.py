"""

6588번 - 골드바흐의 추측
https://www.acmicpc.net/problem/6588

소수를 에라토스테네스의 체로 미리 구하고 숫자를 입력 받았을 때 소수의 합을 출력했다.
골드바흐 추측은 100만 까지는 성립하기 때문에 합을 만들 수 없는 경우는 생각하지 않았다.

체에 짝수가 필요 없어서 짝수 없는 리스트를 만들어 봤지만 메모리가 조금 줄고 속도는 오히려 늘어났다.

"""

import sys

m = 1000001
isPrime = [True] * m
isPrime[1] = False
for p in range(3, m):
    if isPrime[p]:
        for np in range(p * 2, m, p):
            isPrime[np] = False

while 1:
    n = int(sys.stdin.readline())
    if n == 0:
        break
    for i in range(3, n // 2 + 1, 2):
        if isPrime[i] and isPrime[n - i]:
            sys.stdout.write("%d = %d + %d\n" % (n, i, n - i))
            break

# 체에 짝수가 필요 없어서 짝수 없는 리스트를 만들어 봤지만 메모리가 조금 줄고 속도는 오히려 늘어났다.
# import sys
#
# m = 500000
# isPrime = [True] * m
# for p in range(0, m):
#     pp = (p + 1) * 2 + 1
#     if isPrime[p]:
#         for np in range(p + pp, m, pp):
#             isPrime[np] = False
#
# while 1:
#     n = int(sys.stdin.readline())
#     if n == 0:
#         break
#     for i in range(0, n // 4):
#         ii = (i + 1) * 2 + 1
#         if isPrime[i] and isPrime[(n - ii) // 2 - 1]:
#             print("%d = %d + %d" % (n, ii, n - ii))
#             break
