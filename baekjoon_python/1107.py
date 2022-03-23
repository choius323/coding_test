"""

1107번 - 리모컨

조금만 잘못 만들어도 수 많은 반례가 쏟아져 나오는 문제이다.
조건을 꼼꼼히 따지며 어떤 결과가 나올지 예상해야 한다.

lst => [1, 2, 3]
*lst => 1 2 3
*[lst] * 2 => [1, 2, 3] [1, 2, 3]

"""


import sys
from itertools import product

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
error = list(map(str, sys.stdin.readline().split())) if M > 0 else []
button = [str(b) for b in [str(i) for i in range(10)] if b not in error]
count = abs(N - 100)
case = []

for i in range(max(1, len(str(N))-1), min(7, len(str(N))+3)):
    case += [int("".join(lst)) for lst in list(product(*[button] * i)) if int("".join(lst)) <= (N+1) * 10]
case = list(set(case))
# print(case)
for c in case:
    count = min(count, abs(N - c) + len(str(c)))

print(count)
