import math

S, K = map(int, input().split())
num = []
for i in range(K, 0, -1):
    num.append((S - sum(num)) // i)
print(math.prod(num))
