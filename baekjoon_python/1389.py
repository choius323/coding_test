"""

1389번 - 케빈 베이컨의 6단계 법칙
https://www.acmicpc.net/problem/1389

플로이드 와샬(Floyd-Warshall) 알고리즘을 사용하면 간단하게 풀린다.
단, 시간복잡도가 O(n^3)이므로 개수가 적을 때 사용할 수 있다.

참고 자료 : https://ssungkang.tistory.com/entry/Algorithm-%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%99%80%EC%83%ACFloyd-Warshall-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98

"""


import sys

n, m = map(int, sys.stdin.readline().split())
d = [[999999] * n for i in range(n)]
for _ in range(m):
    a, b = map(lambda x: int(x) - 1, sys.stdin.readline().split())
    d[a][b] = d[b][a] = 1

for i in range(n):
    d[i][i] = 0

for k in range(n):
    for b in range(n):
        for a in range(n):
            d[b][a] = min(d[b][a], d[b][k] + d[k][a])

sumD = [sum(s) for s in d]
print(sumD.index(min(sumD)) + 1)
