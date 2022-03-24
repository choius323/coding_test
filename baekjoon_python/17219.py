"""

17219번 - 비밀번호 찾기
https://www.acmicpc.net/problem/17219

사이트와 비밀번호를 딕셔너리에 삽입 해서 사용하면 더 빠르다.

"""


import sys

i = sys.stdin.readline
N, M = map(int, i().split())
p = {k: v for k, v in (i().split() for _ in range(N))}
print("\n".join([p[i()[:-1]] for _ in range(M)]))
