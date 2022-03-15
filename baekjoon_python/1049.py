"""

기타줄

"""

import sys

N, M = map(int, sys.stdin.readline().split())

package = 1000
each = 1000

for i in range(M):
    a, b = map(int, sys.stdin.readline().split())
    package = min(a, package)
    each = min(b, each)

if package <= each * 6:
    money = min(N // 6 * package + N % 6 * each, (N // 6 + 1) * package)
else:
    money = each * N

print(money)
