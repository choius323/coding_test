"""
f(n) = f(n-1) + f(n-2)

f(0)과 f(1)이 호출되는 횟수도 같음
"""

T = int(input())
f = [[1, 0], [0, 1], [1, 1]]
N = []

for _ in range(T):
    N.append(int(input()))

for i in range(3, max(N) + 1):
    f.append([f[i - 1][0] + f[i - 2][0], f[i - 1][1] + f[i - 2][1]])

for n in N:
    print(f[n][0], f[n][1])
