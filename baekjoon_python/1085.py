"""

1085번 - 직사각형에서 탈출
https://www.acmicpc.net/problem/1085

각 선까지 거리의 최소값을 출력하면 된다.

"""


x, y, w, h = map(int, input().split())
print(max(min([x, y, w-x, h-y]), 0))