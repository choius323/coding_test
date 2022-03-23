"""

18870번 - 좌표 압축
https://www.acmicpc.net/problem/18870

시간복잡도는 딕셔너리가 리스트보다 훨씬 빠르다는 것을 알 수 있었던 문제이다.
그리고 딕셔너리에 어떤 키와 값을 넣는 지도 굉장히 중요하다.

"""


import sys

N = int(sys.stdin.readline())
X = list(map(int, sys.stdin.readline().split()))
X2 = sorted(list(set(X)))
dictX = {x: i for i, x in enumerate(X2)}
print(*[dictX[X[i]] for i in range(N)])
