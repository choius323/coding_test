"""

1018번 - 체스판 다시 칠하기

완전 탐색 사용
백트래킹(가지치기) 같은 것들을 사용하지 않아도 시간 초과가 되지 않는다

"""

import sys

N, M = map(int, input().split())
board = [[0 if c == "B" else 1 for c in sys.stdin.readline()] for _ in range(N)]

minChange = 64
for a in range(0, M - 7):
    for b in range(0, N - 7):
        lst = [[a2, b2] for a2 in range(a, a + 8) for b2 in range(b, b + 8)
               if (board[b][a] + board[b2][a2]) % 2 != (a + b + a2 + b2) % 2]
        # print("[%d, %d] : %s" % (a, b, lst))
        minChange = min(minChange, len(lst))
        lst = [[a2, b2] for a2 in range(a, a + 8) for b2 in range(b, b + 8)
               if (board[b][a] + board[b2][a2]) % 2 == (a + b + a2 + b2) % 2]
        # print("[%d, %d] : %s" % (a, b, lst))
        minChange = min(minChange, len(lst))
print(minChange)
