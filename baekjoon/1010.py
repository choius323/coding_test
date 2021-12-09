"""
m(m-1)~~(m-n+1)/(m-n)!

for (int i = 0; i < k; ++i)
{
    ret *= n - i;
    ret /= i + 1;
}
이런 방식으로 해도 됨

"""

from math import factorial

for _ in range(int(input())):
    N, M = map(int, input().split())
    answer = 1
    for a in range(M, N, -1):
        answer *= a
    answer /= factorial(M - N)
    print(int(answer))
