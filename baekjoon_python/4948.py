"""

4948번 - 베르트랑 공준
https://www.acmicpc.net/problem/4948

에라스토테네스의 체를 이용해 소수를 구하고 1~n까지 소수의 개수를 저장한다.
그리고 (2n까지 소수의 개수) - (n까지 소수의 개수)를 출력하면 된다.

"""

import sys

prime = [True] * (123456 * 2 + 1)
count = [0] * (123456 * 2 + 1)

for p in range(2, len(prime)):
    if prime[p]:
        for i in range(p * 2, len(prime), p):
            prime[i] = False
    count[p] = count[p - 1] + (1 if prime[p] else 0)

while 1:
    n = int(sys.stdin.readline())
    if n == 0:
        break
    print(count[2 * n] - count[n])

"""

"""
