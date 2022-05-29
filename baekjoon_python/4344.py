"""

4344번 - 평균은 넘겠지
https://www.acmicpc.net/problem/4344

100을 먼저 곱하고 n으로 나누면 부동소수점이 문제가 되지 않는다.

"""

for _ in range(int(input())):
    n, *lst = list(map(int, input().split()))
    avg = sum(lst) / n
    print("%.3f%%" % (len([c for c in lst if c > avg]) * 100 / n))

# import sys
#
# i = sys.stdin.readline
# for _ in range(int(i())):
#     lst = list(map(int, i().split()))
#     avg = sum(lst[1:]) / lst[0]
#     count = 0
#     for c in range(1, lst[0] + 1):
#         if lst[c] > avg:
#             count += 1
#     print("%.3f%%" % round(count * 100 / lst[0], 3))

"""
6
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91
1 10
"""
