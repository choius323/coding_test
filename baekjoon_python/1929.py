"""

1929번 - 소수 구하기
https://www.acmicpc.net/problem/1929

에라토스테네스의 체를 구현하면 된다.
출력은 소수인지 판별할 때 출력하면 된다.

"""

m, n = map(int, input().split())
isPrime = [True] * 1000001
isPrime[1] = False
for i in range(2, n + 1):
    if isPrime[i]:
        if i >= m:
            print(i)
        for j in range(i, n + 1, i):
            isPrime[j] = False
