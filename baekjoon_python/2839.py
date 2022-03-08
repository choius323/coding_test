"""
설탕 배달
"""

N = int(input())
k5, k3 = 0, 0
for a in range(N // 5, -1, -1):
    for b in range(N // 3 + 1):
        if a * 5 + b * 3 == N:
            k5 = a
            k3 = b
            break
    if k5 + k3 != 0:
        break
print(k5 + k3 if k5 + k3 != 0 else -1)

# print(k5 + k3 if k5 * 5 + k3 * 3 == N else N // 3 if N % 3 == 0 else -1)
